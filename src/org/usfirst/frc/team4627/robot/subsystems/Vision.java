package org.usfirst.frc.team4627.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;
import org.usfirst.frc.team4627.robot.RobotMap;
import org.usfirst.frc.team4627.robot.commands.StartVision;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



/**
 *
 */
public class Vision extends Subsystem {
	
	private static Rectangle2D.Double boundA, boundB;
	private static double areaA, areaB;
	private static double avgArea, distanceRaw, distanceFinal;
	private static double angleX, angleY;
	
	private static VideoCapture camera;
	private static Mat frame;
	private static Rectangle2D.Double bound;
	
	private static NetworkTable nwtable;

	public static void run(){
		init();
		
		while(true){
			if(camera.read(frame)){
				ArrayList<MatOfPoint> contours = new ArrayList<>();
				
				Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2HSV);
				Core.inRange(frame, new Scalar(69.60431654676259, 153.64208633093523, 52.74280575539569), new Scalar(99.69696969696969, 255, 255), frame);
                findContours(frame, contours);
                
                ArrayList<Rectangle2D.Double> bounds = new ArrayList<>();
                
                for (MatOfPoint contour : contours){
                	
                	bound = new Rectangle2D.Double(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
                	
                	
                	for (int i = 0; i < contour.height();i++){
                		double[] data = contour.get(i, 0);
                		
                		bound.x = Math.min(bound.x, data[0]);
                		bound.y = Math.min(bound.y, data[1]);
                		bound.width = Math.min(bound.width, data[0] - bound.x);
                		bound.height = Math.min(bound.height, data[1] - bound.y);
                	}
                	
                	bound.add(bound);
                }
                
                Collections.sort(bounds,new Comparator<Rectangle2D.Double>(){
                	@Override
                	public int compare(Rectangle2D.Double o1, Rectangle2D.Double o2){
                		return (int) (o2.width * o2.height - o1.width * o1.height);
                	}
                });
                
                if (bounds.size() >= 2){
                	
                	boundA = bounds.get(0);
                	boundB = bounds.get(1);
                	
                	areaA = boundA.width * boundA.height;
                	areaB = boundB.width * boundB.height;
                	
                	avgArea = (areaA + areaB) / 2;
                	distanceRaw  = 60/Math.sqrt(avgArea) - 0.05;
                	distanceFinal = Math.round(distanceRaw*100.0)/100.0;
                }
                pushTables();
			}
		}	
	}
	
	private static void pushTables(){
		nwtable.putNumber("distanceFinal", distanceFinal);
		nwtable.putBoolean("isCentered", isCentered());
		//nwtable.putNumber("angleX", angleX);
		//nwtable.putNumber("angleY", angleY);
	}
	
	public static boolean isCentered(){
		return isCentered(10);
	}
	
	public static boolean isCentered(double margin){
		double cA = boundA.x + boundA.width / 2;
		double cB = boundB.x + boundB.width / 2;
		
		double boardCenter = (cA  + cB) / 2;
		
		return Math.abs(boardCenter - frame.width()/2) < margin;
	}
	
	private static void init(){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		camera = new VideoCapture(RobotMap.CAMERA_1);
		camera.set(Videoio.CAP_PROP_AUTO_EXPOSURE, 1);
		camera.set(Videoio.CAP_PROP_EXPOSURE, -11);
		
		frame = new Mat();
		
		nwtable = NetworkTable.getTable("dataTables");
	}

	private static void findContours(Mat input, ArrayList<MatOfPoint> contours){
		Mat hierarchy = new Mat();
		contours.clear();
		int mode = Imgproc.RETR_LIST;
		int method = Imgproc.CHAIN_APPROX_SIMPLE;
		Imgproc.findContours(input, contours, hierarchy, mode, method);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new StartVision());
    }
}

