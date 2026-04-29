    package LAB5;

    import java.util.*;

    public class ConvexHull implements TwoDimAlgorithm {
        private String name;
        private  ArrayList<int[]> vertices;
        public ConvexHull(String name){
            this.name = name;
        }

        @Override
        public int[] algorithm(int[][] arr, int target){
//            ArrayList<int[]> hull = grahamScan(arr);
            solve(arr);
            return null;
        }

        @Override
        public int bestCaseSetup(int[][] arr, int target){
            return 0;
        }

        @Override
        public int averageCaseSetup(int[][] arr, int target){
            return 0;
        }

        @Override
        public int worstCaseSetup(int[][] arr, int target){
            return 0;
        }

        @Override
        public String getName(){
            return name;
        }

        private  ArrayList<int[]> solve(int[][] points){
            vertices = new ArrayList<>();
            ArrayList<int[]> pointsList = new ArrayList<>();

            for(int[] point : points){
                pointsList.add(point);
            }

            ArrayList<int[]> leftList = new ArrayList<>();
            ArrayList<int[]> rightList = new ArrayList<>();

            int[] point1 = getMaxX(points);
            int[] point2 = getMinX(points);
            vertices.add(point1);
            vertices.add(point2);

            leftList = getLeftList(point1, point2, pointsList);
            rightList = getLeftList(point2, point1, pointsList);

            divideAndConquer(point1, point2, leftList);
            divideAndConquer(point2, point1, rightList);
            return vertices;
        }

        private  void divideAndConquer(int[] point1, int[] point2, ArrayList<int[]> points){
            if(points.isEmpty()) return;
            int[] farthestPoint = getFarthestPointOnLeft(points, point1, point2);
            ArrayList<int[]> leftEdgeList = new ArrayList<>();
            ArrayList<int[]> rightEdgeList = new ArrayList<>();
            vertices.add(farthestPoint);
            leftEdgeList = getLeftList(point1,farthestPoint,points);
            rightEdgeList = getLeftList(farthestPoint,point2,points);
            leftEdgeList.remove(farthestPoint);
            rightEdgeList.remove(farthestPoint);
            divideAndConquer(point1, farthestPoint, leftEdgeList);
            divideAndConquer(farthestPoint, point2, rightEdgeList);
        }

        private  boolean isOnLeft(){
            return false;
        }

        private  int[] getFarthestPointOnLeft(ArrayList<int[]> points, int[] point1, int[] point2){
            int[] farthestPoint = null;

            int dist = 0;
            for(int[] point : points){
                int tempdist = getDistance(point1, point2, point);
                if(tempdist > dist){
                    dist = tempdist;
                    farthestPoint = point;
                }
            }
            return farthestPoint;
        }

        private ArrayList<int[]> getLeftList(int[] p1, int[] p2, ArrayList<int[]> points){
            ArrayList<int[]> tempList = new ArrayList<>();
            for(int[] point : points){
                int tempdist = getDistance(p1, p2, point);
                if(tempdist > 0){
                tempList.add(point);
                }
            }
            return  tempList;
        }

        private  int getDistance(int[] pt1, int[] pt2, int[] pt3){
            return (pt1[0] * (pt2[1] - pt3[1])) - (pt2[0] * (pt1[1] - pt3[1])) + (pt3[0] * (pt1[1] - pt2[1]));
        }

        private  int[] getMaxX(int[][] points){
            int[] pointMaxX = {Integer.MIN_VALUE,0};
            for(int[] point : points){
                if(pointMaxX[0] < point[0]) pointMaxX = point;
            }
            return pointMaxX;
        }

        private  int[] getMinX(int[][] points){
            int[] pointMinX = {Integer.MAX_VALUE,0};
            for(int[] point : points){
                if(point[0] < pointMinX[0]) pointMinX = point;
            }
            return pointMinX;
        }

        private ArrayList<int[]> grahamScan(int[][] points) {
            ArrayList<int[]> pts = new ArrayList<>();
            for (int[] p : points) pts.add(p);

            if (pts.size() < 3) return pts;

            // 1. Find lowest point (y min, then x min)
            int[] p0 = pts.get(0);
            for (int[] p : pts) {
                if (p[1] < p0[1] || (p[1] == p0[1] && p[0] < p0[0])) {
                    p0 = p;
                }
            }

            int[] finalP0 = p0;

            // 2. Sort by polar angle
            pts.sort((a, b) -> {
                if (a == finalP0) return -1;
                if (b == finalP0) return 1;

                int orient = orientation(finalP0, a, b);

                if (orient == 0) {
                    // closer one first
                    return distanceSq(finalP0, a) - distanceSq(finalP0, b);
                }

                return (orient == 2) ? -1 : 1; // counterclockwise first
            });

            Stack<int[]> stack = new Stack<>();

            // 3. Push first 3 points
            stack.push(pts.get(0));
            stack.push(pts.get(1));
            stack.push(pts.get(2));

            // 4. Process remaining points
            for (int i = 3; i < pts.size(); i++) {
                while (stack.size() >= 2 &&
                        orientation(nextToTop(stack), stack.peek(), pts.get(i)) != 2) {
                    stack.pop();
                }
                stack.push(pts.get(i));
            }

            return new ArrayList<>(stack);
        }


        private int orientation(int[] p, int[] q, int[] r) {
            int val = (q[1] - p[1]) * (r[0] - q[0]) -
                    (q[0] - p[0]) * (r[1] - q[1]);

            if (val == 0) return 0;      // collinear
            return (val > 0) ? 1 : 2;    // 1 = clockwise, 2 = counterclockwise
        }

        private int distanceSq(int[] p1, int[] p2) {
            return (p1[0] - p2[0]) * (p1[0] - p2[0]) +
                    (p1[1] - p2[1]) * (p1[1] - p2[1]);
        }

        private int[] nextToTop(Stack<int[]> stack) {
            int[] top = stack.pop();
            int[] res = stack.peek();
            stack.push(top);
            return res;
        }

        private  String toMyString(){
            String res = "";
            res += "Points to form the polygon are: ";
            System.out.print("Points to form the polygon are: ");
            for (int[] point : vertices){
                res += "(";
                System.out.print("(");
                for(int coOrd : point){
                    System.out.print(coOrd + ", ");
                }
                System.out.print("),");
            }
            return res;
        }

        public static void main(String[] args){
            ConvexHull ch = new ConvexHull("ConvexHull");
    //        int[][] points = {{1,1},{1,3},{-1,2},{3,1},{0,0},{-21,21}};

    //        int[][] points = {{1,-4},{-1,-5},{-5,-3},{-3,-1},{0,0},{-1,1}};
    //        ch.solve(points);
    //        ch.toMyString();

            int size = 100;
            Timing2DAlgorithms framework = new Timing2DAlgorithms(ch, 1000, "Lab-Programs/src/LAB5/Data/");
            int[][] sizes = new int[size][2];
            int counter = 0;
            for(int i = 100; i <= size*100; i += 100){
                sizes[counter][0] = i;
                sizes[counter][1] = 2;
                counter++;
            }
            boolean[] choices = {false,false,true};
            framework.initiate(sizes, choices);
        }
    }
