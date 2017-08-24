package com.ziytek.taozhu.base.util;

import java.io.Serializable;
import java.util.List;

/**
 * 类描述：
 *
 * @author by zhanggl on 2016/12/1.
 */
public class MathUtil implements Serializable {

    public static final double MIN_VALUE = 10E-10;

    /**
     * 检查多边形是否包含了某点~
     *
     * @param point
     * @return
     */
    public static boolean containsPoint(Point point, List<Point> vertices) {
        int verticesCount = vertices.size();
        int nCross = 0;
        for (int i = 0; i < verticesCount; ++i) {
            Point p1 = vertices.get(i);
            Point p2 = vertices.get((i + 1) % verticesCount);

            // 求解 y=p.y 与 p1 p2 的交点
            if (Math.abs(p1.getLongitude() - p2.getLongitude()) > -1 * MIN_VALUE && Math.abs(p1.getLongitude() - p2.getLongitude()) < MIN_VALUE) {   // p1p2 与 y=p0.y平行
                continue;
            }
            if (point.getLongitude() < Math.min(p1.getLongitude(), p2.getLongitude())) { // 交点在p1p2延长线上
                continue;
            }
            if (point.getLongitude() >= Math.max(p1.getLongitude(), p2.getLongitude())) { // 交点在p1p2延长线上
                continue;
            }
            // 求交点的 X 坐标
            double x = (point.getLongitude() - p1.getLongitude()) * (p2.getLatitude() - p1.getLatitude())
                    / (p2.getLongitude() - p1.getLongitude()) + p1.getLatitude();

            if (x > point.getLatitude()) { // 只统计单边交点
                nCross++;
            }
        }
        // 单边交点为偶数，点在多边形之外
        return (nCross % 2 == 1);
    }

}
