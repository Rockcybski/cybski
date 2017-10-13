package com.rock.cybski.leetcode_lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 给定一些 points 和一个 origin，从 points 中找到 k 个离 origin 最近的点。按照距离由小到大返回。如果两个点有相同距离，则按照x值来排序；若x值也相同，就再按照y值排序
 */
public class KNearestPoints {
	/*
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        ArrayList<Point> resultList = new ArrayList<>();
        Point[] result = new Point[k];
        Point tempMax = null;
        PointComparator pointComparator = new PointComparator(origin);
		for (int i = 0; i < points.length; i++) {
			if (i < k) {
				resultList.add(points[i]);
			}
			if (i == k) {
				Collections.sort(resultList, pointComparator);
				tempMax = resultList.get(resultList.size() - 1);
			}
			if (i >= k) {
				if (pointComparator.compare(points[i], tempMax) >= 0) {
					continue;
				} else {
					for (int j = 0; j < resultList.size(); j++) {
						if (pointComparator.compare(points[i], resultList.get(j)) < 0) {
							resultList.add(j, points[i]);
							break;
						}
						if (j == resultList.size() - 1) {
							resultList.add(resultList.size() - 1, points[i]);
							break;
						}
					}
					resultList.remove(resultList.size() - 1);
					tempMax = resultList.get(resultList.size() - 1);
				}
			}
		}
        return resultList.toArray(result);
    }
    
    private class PointComparator implements Comparator<Point>{
    	private Point origin;
    	public PointComparator(Point origin) {
    		this.origin = origin;
    	}
		@Override
		public int compare(Point o1, Point o2) {
			int d1 = getDistanceSquareFromOrigin(o1, origin);
			int d2 = getDistanceSquareFromOrigin(o2, origin);
			if (d1 != d2) {
				return d1 - d2;
			} else {
				if (o1.x != o2.x) {
					return o1.x - o2.x;
				} else {
					return o1.y - o2.y;
				}
			}
		}
    }
    
    private int getDistanceSquareFromOrigin(Point p, Point origin) {
    	int xDiff = p.x - origin.x;
    	int yDiff = p.y - origin.y;
    	return xDiff * xDiff + yDiff * yDiff;
    }
    
    public static void main(String[] args) {
		Point[] points = {new Point(4, 6), new Point(4, 7), new Point(4, 4), new Point(2, 5), new Point(1, 1)};
		Point o = new Point(0, 0);
		Point[] result = new KNearestPoints().kClosest(points, o, 3);
		System.out.println(result);
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}
