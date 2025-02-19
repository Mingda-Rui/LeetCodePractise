package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

public class _16_3Intersection {
    private IntersectionPoint intersection(IntersectionLine line1, IntersectionLine line2) {
        if (line1.isSameLine(line2)) {
            return line1.start;
        }

        if (line1.isParallel(line2)) {
            return null;
        }

        return line1.getIntersection(line2);
    }
}

class IntersectionLine {
    IntersectionPoint start, end;

    public double getSlope() {
        return (start.y - end.y) / (start.x - end.x);
    }

    public double getYIntercept() {
        return start.y - getSlope() * start.x;
    }

    public boolean isParallel(IntersectionLine line) {
        return getSlope() == line.getSlope();
    }

    public boolean isSameLine(IntersectionLine line) {
        return isParallel(line) && getYIntercept() == line.getYIntercept();
    }

    public IntersectionPoint getIntersection(IntersectionLine line) {
        double slope1 = getSlope();
        double slope2 = line.getSlope();
        double offset1 = getYIntercept();
        double offset2 = line.getYIntercept();
        double intersectionX = (offset2 - offset1) / (slope1 - slope2);
        double intersectionY = slope1 * intersectionX + offset1;
        return new IntersectionPoint(intersectionX, intersectionY);
    }
}

class IntersectionPoint {
    double x, y;

    public IntersectionPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
}