/**
 * This class is ...
 *
 * <P>
 *
 * <P>
 *
 * @SINCE 1.0
 * @AUTHOR RCARON
 * @VERSION 1.0
 */
package com.blastvibrations.jpa.util;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;

/*
 import org.geotools.referencing.CRS;
 import org.geotools.referencing.crs.DefaultGeographicCRS;
 import org.opengis.referencing.FactoryException;
 import org.opengis.referencing.NoSuchAuthorityCodeException;
 import org.opengis.referencing.crs.CoordinateReferenceSystem;
 s
 import com.vividsolutions.jts.geom.Geometry;
 import com.vividsolutions.jts.geom.Point;
 import com.vividsolutions.jts.io.ParseException;
 import com.vividsolutions.jts.io.WKTReader;
 */

public class PTMGeometryUtil {

	public static int LATLONG_PROJECTION_SRID = 4326;

	public static int GOOGLE_PROJECTION_SRID = 900913;

	public static Geometry createPoint(final BigDecimal lng,
			final BigDecimal lat) {
		if (lng == null && lat == null) {
			return null;
		} else {
			return createPoint((lng == null ? 0d : lng.doubleValue()),
					(lat == null ? 0d : lat.doubleValue()));
		}
	}

	public static Geometry createPoint(final BigDecimal lng,
			final BigDecimal lat, final BigDecimal z) {
		if (lng == null && lat == null) {
			return null;
		} else {
			return createPointZ((lng == null ? 0d : lng.doubleValue()),
					(lat == null ? 0d : lat.doubleValue()),
					(z == null ? 0d : z.doubleValue()));
		}
	}

	public static Geometry createPoint(final String lng, final String lat) {
		if (StringUtils.isBlank(lng) && StringUtils.isBlank(lat)) {
			return null;
		} else {
			return createPoint(
					(StringUtils.isBlank(lng) ? 0d : Double.parseDouble(lng)),
					(StringUtils.isBlank(lat) ? 0d : Double.parseDouble(lat)));
		}
	}

	public static Geometry createPoint(final String lng, final String lat,
			final String z) {
		if (StringUtils.isBlank(lng) && StringUtils.isBlank(lat)
				&& StringUtils.isBlank(z)) {
			return null;
		} else {
			return createPointZ(
					(StringUtils.isBlank(lng) ? 0d : Double.parseDouble(lng)),
					(StringUtils.isBlank(lat) ? 0d : Double.parseDouble(lat)),
					(StringUtils.isBlank(z) ? 0d : Double.parseDouble(z)));
		}
	}

	public static Geometry createPoint(final double lng, final double lat) {
		return createPoint(lng, lat, LATLONG_PROJECTION_SRID);
	}

	public static Geometry createPointZ(final double lng, final double lat,
			final double z) {
		return createPointZ(lng, lat, z, LATLONG_PROJECTION_SRID);
	}

	public static Geometry createPoint(final double lng, final double lat,
			final int SRID) {

		final GeometryFactory geometryFactory = new GeometryFactory(
				new PrecisionModel(), SRID);

		final Coordinate coord = new Coordinate(lng, lat);

		return geometryFactory.createPoint(coord);
	}

	public static Geometry createPointZ(final double lng, final double lat,
			final double z, final int SRID) {

		final GeometryFactory geometryFactory = new GeometryFactory(
				new PrecisionModel(), SRID);

		final Coordinate coord = new Coordinate(lng, lat, z);

		return geometryFactory.createPoint(coord);
	}

	/*
	 * FOR FUTURE PURPUSE
	 * 
	 * public static int GOOGLE_PROJECTION_SRID = 900913; public static int
	 * LATLONG_PROJECTION_SRID = 4326;
	 * 
	 * public static CoordinateReferenceSystem GOOGLE_PROJECTION_CRS = null;
	 * public static CoordinateReferenceSystem LATLONG_PROJECTION_CRS =
	 * DefaultGeographicCRS.WGS84;
	 * 
	 * private static final String GOOGLE_900913_WKT =
	 * "PROJCS[\"Google Mercator\", \r\n" + "  GEOGCS[\"WGS 84\", \r\n" +
	 * "    DATUM[\"World Geodetic System 1984\", \r\n" +
	 * "      SPHEROID[\"WGS 84\", 6378137.0, 298.257223563, AUTHORITY[\"EPSG\",\"7030\"]], \r\n"
	 * + "      AUTHORITY[\"EPSG\",\"6326\"]], \r\n" +
	 * "    PRIMEM[\"Greenwich\", 0.0, AUTHORITY[\"EPSG\",\"8901\"]], \r\n" +
	 * "    UNIT[\"degree\", 0.017453292519943295], \r\n" +
	 * "    AXIS[\"Geodetic latitude\", NORTH], \r\n" +
	 * "    AXIS[\"Geodetic longitude\", EAST], \r\n" +
	 * "    AUTHORITY[\"EPSG\",\"4326\"]], \r\n" +
	 * "  PROJECTION[\"Mercator (1SP)\", AUTHORITY[\"EPSG\",\"9804\"]], \r\n" +
	 * "  PARAMETER[\"semi_major\", 6378137.0], \r\n" +
	 * "  PARAMETER[\"semi_minor\", 6378137.0], \r\n" +
	 * "  PARAMETER[\"latitude_of_origin\", 0.0], \r\n" +
	 * "  PARAMETER[\"central_meridian\", 0.0], \r\n" +
	 * "  PARAMETER[\"scale_factor\", 1.0], \r\n" +
	 * "  PARAMETER[\"false_easting\", 0.0], \r\n" +
	 * "  PARAMETER[\"false_northing\", 0.0], \r\n" + "  UNIT[\"m\", 1.0], \r\n"
	 * + "  AXIS[\"Easting\", EAST], \r\n" + "  AXIS[\"Northing\", NORTH], \r\n"
	 * + "  AUTHORITY[\"EPSG\",\"900913\"]]";
	 * 
	 * static { try { //How to get the SRID //
	 * Integer.valueOf(((org.geotools.referencing
	 * .NamedIdentifier)LATLONG_PROJECTION_CRS
	 * .getIdentifiers().toArray()[0]).getCode()); GOOGLE_PROJECTION_CRS =
	 * CRS.parseWKT(GOOGLE_900913_WKT); } catch (NoSuchAuthorityCodeException e)
	 * { e.printStackTrace(); } catch (FactoryException e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * public static Geometry convertWktToGeometry(String wktPoint) {
	 * //DefaultGeographicCRS
	 * .WGS84.getCoordinateSystem().getName().getAuthority() return
	 * convertWktToGeometry(wktPoint, LATLONG_PROJECTION_SRID);
	 * //SRID_WGS84_CRS.); }
	 * 
	 * public static Geometry convertWktToGeometry(String wktPoint, int SRID) {
	 * WKTReader fromText = new WKTReader(); Geometry geom = null; try { geom =
	 * fromText.read(wktPoint); geom.setSRID(SRID); } catch (ParseException e) {
	 * throw new RuntimeException("Not a WKT string:" + wktPoint); } return
	 * geom; }
	 * 
	 * public static double getGeometryLong(String wktPoint) { Geometry geom =
	 * convertWktToGeometry(wktPoint, LATLONG_PROJECTION_SRID); Point p =
	 * (Point)geom; return p.getX(); }
	 * 
	 * public static double getGeometryLat(String wktPoint) { Geometry geom =
	 * convertWktToGeometry(wktPoint, LATLONG_PROJECTION_SRID); Point p =
	 * (Point)geom; return p.getX(); }
	 * 
	 * public static double getGeometryLong(String wktPoint, int SRID) {
	 * Geometry geom = convertWktToGeometry(wktPoint, SRID); Point p =
	 * (Point)geom; return p.getX(); }
	 * 
	 * public static double getGeometryLat(String wktPoint, int SRID) { Geometry
	 * geom = convertWktToGeometry(wktPoint, SRID); Point p = (Point)geom;
	 * return p.getX(); }
	 * 
	 * public static Point getGeometryPoint(double lat, double lng) { return
	 * getGeometryPoint(lat, lng, LATLONG_PROJECTION_SRID); }
	 * 
	 * public static Point getGeometryPoint(double lat, double lng, int SRID) {
	 * Geometry geom = convertWktToGeometry(makePoint(lat, lng), SRID); return
	 * (Point)geom; }
	 * 
	 * public static String makePoint(double lat, double lng) { return "POINT ("
	 * + lng + " " + lat + ")"; }
	 */

}
