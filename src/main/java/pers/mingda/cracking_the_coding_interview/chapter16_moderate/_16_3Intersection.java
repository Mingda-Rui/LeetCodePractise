package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.Optional;

public class _16_3Intersection {
    private Optional<IntersectionPoint> intersection(IntersectionLine line1, IntersectionLine line2) {
        if (line1.isParallelOverlap(line2)) {
            return Optional.of(line1.start);
        }

        if (line1.isParallel(line2)) {
            return Optional.empty();
        }

        IntersectionPoint infiniteIntersection =  line1.getIntersection(line2);
        return line1.isBetween(infiniteIntersection) && line2.isBetween(infiniteIntersection)
                ? Optional.of(infiniteIntersection) : Optional.empty();
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

    public boolean isParallelOverlap(IntersectionLine line) {
        if (!isSameInfiniteLine(line)) {
            return false;
        }
        return (isBetween(line.start) && isBetween(line.end)) || (line.isBetween(start) && line.isBetween(end));
    }

    public boolean isBetween(IntersectionPoint point) {
        boolean containX = Math.min(start.x, end.x) <= point.x  && point.x <= Math.max(start.x, end.x);
        boolean containY = Math.min(start.y, end.y) <= point.y  && point.y <= Math.max(start.y, end.y);
        return containX && containY;
    }

    private boolean isSameInfiniteLine(IntersectionLine line) {
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