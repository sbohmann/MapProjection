package at.yeoman.map.projection;

public class MercatorProjection {
    public static double yForLatitude(double latitude) {
        return Math.log(1.0 / Math.cos(latitude) + Math.sin(latitude) / Math.cos(latitude));
    }

    public static double latitudeForY(Double x) {
        return Math.atan(Math.sinh(x));
    }
}