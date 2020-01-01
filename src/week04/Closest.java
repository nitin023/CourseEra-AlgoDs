package week04;

import java.io.*;
import java.util.*;


public class Closest {

    static class Point{
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static double minimalDistance(Point a[]) {
        double ans = Double.POSITIVE_INFINITY;
        double distance = 0;
        for(int i = 0 ; i+1 < a.length ; i++)
        {
            if(a[i]!=null && a[i+1]!=null) {
                distance = Math.sqrt((a[i + 1].x - a[i].x) * (a[i + 1].x - a[i].x) + (a[i + 1].y - a[i].y) * (a[i + 1].y - a[i].y));
                if (ans > distance) {
                    ans = distance;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimalDistanceOptimized(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

    static double minimalDistanceOptimized(int []x , int [] y)
    {
        Point p[] = new Point[x.length];
        for(int i = 0 ; i <x.length ; i++)
        {
            p[i] = new Point(x[i],y[i]);
        }
        closest(p);
        return closestUtil(p,x.length);
    }
    static double closest(Point P[])
    {
        List<Point> allPoints = Arrays.asList(P);
        Collections.sort(allPoints,compareX);
        Point p [] = new Point[allPoints.size()];
        int i = 0;
        for(Point m : allPoints)
        {
            p[i++] = m;
        }
        return closestUtil(p,allPoints.size());
    }

    static Comparator<Point> compareX = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return Long.compare(o1.x , o2.x);
        }
    };

    static Comparator<Point> compareY = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return Long.compare(o1.y , o2.y);
        }
    };

    static double closestUtil(Point P[], int n)
    {
        // If there are 2 or 3 points, then use brute force
        if (n <= 3)
            return minimalDistance(P);

        // Find the middle point
        int mid = n/2;
        Point midPoint = P[mid];


        double dl = closestUtil(P, mid);
        Point pr[] = new Point[n-mid];
        for(int i = mid , j = 0 ; i < P.length && j<pr.length ; i++,j++)
        {
            pr[j] = P[i];
        }
        double dr = closestUtil(pr , n - mid);

        // Find the smaller of two distances
        double d = Math.min(dl, dr);

        Point strip[] = new Point[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(P[i].x - midPoint.x) < d) {
                strip[j] = P[i];
                j++;
            }
        }

        return Math.min(d, stripClosest(strip,j,d));
    }

    static double stripClosest(Point strip[], int size, double d)
    {
        if(size==0)
        {
            return d;
        }
        double min = d; // Initialize the minimum distance as d

        List<Point> allPoints = new ArrayList<>();
        for(int i = 0 ; i < strip.length ; i++)
        {
            if(strip[i]!=null)
            {
                allPoints.add(strip[i]);
            }
        }
        Collections.sort(allPoints,compareY);

        for(int i = 0 ; i < size ; i++)
        {
            for(int j = i + 1 ; j < size && (allPoints.get(j).y - allPoints.get(i).y) < min ; j++)
            {
                if(dist(allPoints.get(i) , allPoints.get(j)) < min)
                {
                    min = dist(allPoints.get(i), allPoints.get(j));
                }
            }
        }

        return min;
    }

    static double dist(Point p1, Point p2)
    {
        return Math.sqrt( (p1.x - p2.x)*(p1.x - p2.x) +
                (p1.y - p2.y)*(p1.y - p2.y)
        );
    }
}