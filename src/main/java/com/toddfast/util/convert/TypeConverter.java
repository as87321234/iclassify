package com.toddfast.util.convert;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.StringTokenizer;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.pointtomap.iclassify.jpa.orm.enumeration.GroupMemberShipEnum;
import com.pointtomap.iclassify.jpa.orm.enumeration.PermissionBlastReportEnum;
import com.toddfast.util.convert.StringWrapper.TypeConversion;
import com.toddfast.util.convert.conversion.IdentityTypeConversion;
import com.toddfast.util.convert.conversion.ObjectTypeConversion;

/**
 * Provides an efficient and robust mechanism for converting an object to a
 * different type. For example, one can convert a {@link String} to an
 * {@link Integer} using the {@link TypeConverter} like this:
 *
 * <pre>
 * Integer i = (Integer) TypeConverter.convert(Integer.class, &quot;123&quot;);
 * </pre>
 *
 * or using the shortcut method:
 *
 * <pre>
 * int i = TypeConverter.asInt(&quot;123&quot;);
 * </pre>
 *
 * The {@link TypeConverter} comes ready to convert all the primitive types,
 * plus a few more like {@link java.sql.Date} and {@link java.math.BigDecimal}.
 * <p>
 *
 * It is possible to register classes that implement the new {@link Conversion}
 * interface for conversion to a custom type. For example, this means that you
 * can define a class to convert arbitrary objects to type <code>Foo</code>, and
 * register it for use throughout the VM:
 *
 * <pre>
 * 	Conversion<?> fooConversion = new FooConversion();
 * 	TypeConverter.registerTypeConversion(Foo.class, fooConversion);
 * 	...
 * 	Bar bar = new Bar();
 * 	Foo foo = TypeConverter.convert(Foo.class, bar);
 * 	...
 * 	String s = "bar";
 * 	Foo foo = TypeConverter.convert(Foo.class, s);
 * </pre>
 *
 * {@link Conversion} classes are also discovered using the JDK's standard
 * {@link ServiceLoader} mechanism. To make a conversion discoverable, place a
 * file named
 * <code>META-INF/services/com.toddfast.util.typeconverter.TypeConverter$Conversion</code>
 * in your project, the contents of which are fully qualified {@link Conversion}
 * , class names, one per line. See the {@link ServiceLoader} documentation for
 * more details on how to use the <code>META-INF/services</code> mechanism.
 * <p>
 * The {@link TypeConverter} allows specification of an arbitrary <i>type
 * key</i> in the {@link #registerTypeConversion(Object,TypeConversion)} and
 * {@link #convert(Object,Object)} methods, so one can simultaneously register a
 * conversion object under a {@link Class} object, a class name, and one or more
 * logical type name. For example, the following are valid ways of converting a
 * string to an <code>int</code>:
 *
 * <pre>
 * Integer i = TypeConverter.convert(Integer.class, &quot;123&quot;);
 * Integer i = (Integer) TypeConverter.convert(&quot;java.lang.Integer&quot;, &quot;123&quot;);
 * Integer i = (Integer) TypeConverter.convert(TypeConverter.TYPE_INT, &quot;123&quot;);
 * Integer i = (Integer) TypeConverter.convert(TypeConverter.TYPE_INTEGER, &quot;123&quot;);
 * Integer i = (Integer) TypeConverter.convert(&quot;int&quot;, &quot;123&quot;);
 * Integer i = (Integer) TypeConverter.convert(&quot;integer&quot;, &quot;123&quot;);
 * int i = TypeConverter.asInt(&quot;123&quot;);
 * </pre>
 *
 * Default type conversions have been registered under the following keys:
 *
 * <pre>
 * Classes:
 * 	java.lang.Object
 * 	java.lang.String
 * 	java.lang.Integer
 * 	java.lang.Integer.TYPE (int)
 * 	java.lang.Double
 * 	java.lang.Double.TYPE (double)
 * 	java.lang.Boolean
 * 	java.lang.Boolean.TYPE (boolean)
 * 	java.lang.Long
 * 	java.lang.Long.TYPE (long)
 * 	java.lang.Float
 * 	java.lang.Float.TYPE (float)
 * 	java.lang.Short
 * 	java.lang.Short.TYPE (short)
 * 	java.lang.Byte
 * 	java.lang.Byte.TYPE (byte)
 * 	java.lang.Character
 * 	java.lang.Character.TYPE (char)
 * 	java.math.BigDecimal
 * 	java.sql.Date
 * 	java.sql.Time
 * 	java.sql.Timestamp
 * 
 * Class name strings:
 * 	"java.lang.Object"
 * 	"java.lang.String"
 * 	"java.lang.Integer"
 * 	"java.lang.Double"
 * 	"java.lang.Boolean"
 * 	"java.lang.Long"
 * 	"java.lang.Float"
 * 	"java.lang.Short"
 * 	"java.lang.Byte"
 * 	"java.lang.Character"
 * 	"java.math.BigDecimal"
 * 	"java.sql.Date"
 * 	"java.sql.Time"
 * 	"java.sql.Timestamp"
 * 
 * Logical type name string constants:
 * 	TypeConverter.TYPE_UNKNOWN ("null")
 * 	TypeConverter.TYPE_OBJECT ("object")
 * 	TypeConverter.TYPE_STRING ("string")
 * 	TypeConverter.TYPE_INT ("int")
 * 	TypeConverter.TYPE_INTEGER ("integer")
 * 	TypeConverter.TYPE_DOUBLE ("double")
 * 	TypeConverter.TYPE_BOOLEAN ("boolean")
 * 	TypeConverter.TYPE_LONG ("long")
 * 	TypeConverter.TYPE_FLOAT ("float")
 * 	TypeConverter.TYPE_SHORT ("short")
 * 	TypeConverter.TYPE_BYTE ("byte")
 * 	TypeConverter.TYPE_CHAR ("char")
 * 	TypeConverter.TYPE_CHARACTER ("character")
 * 	TypeConverter.TYPE_BIG_DECIMAL ("bigdecimal")
 * 	TypeConverter.TYPE_SQL_DATE ("sqldate")
 * 	TypeConverter.TYPE_SQL_TIME ("sqltime")
 * 	TypeConverter.TYPE_SQL_TIMESTAMP ("sqltimestamp")
 * </pre>
 *
 * The {@link TypeConverter} treats type keys of type {@link Class} slightly
 * differently than other keys. If the provided value is already of the type
 * specified by the type key class, it is returned without a conversion taking
 * place. For example, a value of type <code>MySub</code> that extends the class
 * <code>MySuper</code> would not be converted in the following situation
 * because it is already of the necessary type:
 *
 * <pre>
 * MySub o = TypeConverter.convert(MySuper.class, mySub);
 * </pre>
 *
 * Finally, a class can optionally implement the {@link Listener} and/or
 * {@link Convertible} interfaces to receive conversion events or provide its
 * own {@link Conversion} instance, respectively. This capability allows a class
 * to implement very rich custom type conversion logic.
 * <p>
 *
 * Be warned that although the type conversion infrastructure in this class is
 * desgned to add only minimal overhead to the conversion process, conversion of
 * an object to another type is a potentially expensive operation and should be
 * used with discretion.
 *
 * @see Convertible
 * @see Conversion
 * @see Listener
 */
public class TypeConverter {

    /**
     * Cannot instantiate
     *
     */
    private TypeConverter() {
	super();
    }

    /**
     * Return the map of type conversion objects. The keys for the values in
     * this map may be arbitrary objects, but the values are of type
     * <code>Conversion</code>.
     *
     */
    private static Map<Object, Conversion<?>> getTypeConversions() {
	return typeConversions;
    }

    /**
     * Register a type conversion object under the specified key. This method
     * can be used by developers to register custom type conversion objects.
     *
     */
    public static void registerTypeConversion(final Object key,
	    final Conversion<?> conversion) {
	typeConversions.put(key, conversion);
    }

    /**
     * Unregister a type conversion object under the specified key
     *
     */
    public static void unregisterTypeConversion(final Object key) {
	typeConversions.remove(key);
    }

    /**
     * Register a type conversion object under the specified keys. This method
     * can be used by developers to register custom type conversion objects.
     *
     */
    public static void registerTypeConversion(final Conversion<?> conversion) {

	final Object[] keys = conversion.getTypeKeys();
	if (keys == null) {
	    return;
	}

	for (int i = 0; i < keys.length; i++) {
	    registerTypeConversion(keys[i], conversion);
	}
    }

    /**
     * Unregister a type conversion object under all keys it specifies via the
     * {@link TypeConversion#getTypeKeys} method. Note, if this conversion is
     * registered under other type keys, it will NOT be removed from those.
     *
     */
    public static void unregisterTypeConversion(final Conversion<?> conversion) {
	if (conversion != null) {
	    final Object[] keys = conversion.getTypeKeys();
	    synchronized (typeConversions) {
		if (keys == null) {
		    for (int i = 0; i < keys.length; i++) {
			unregisterTypeConversion(keys[i]);
		    }
		}

		for (final Object key : getTypeKeys(conversion)) {
		    typeConversions.remove(key);
		}
	    }
	}
    }

    /**
     * Discover all the type key mappings for this conversion
     *
     */
    private static List<Object> getTypeKeys(final Conversion<?> conversion) {

	final List<Object> result = new ArrayList<Object>();

	synchronized (typeConversions) {
	    // Clone the conversions
	    final Map<Object, Conversion<?>> map = new HashMap<Object, Conversion<?>>(
		    typeConversions);

	    // Find all keys that map to this conversion instance
	    for (final Map.Entry<Object, Conversion<?>> entry : map.entrySet()) {
		if (entry.getValue() == conversion) {
		    result.add(entry.getKey());
		}
	    }
	}

	return result;
    }

    /**
     * Return a {@link Conversion} to the target type. Note, the returned
     * conversion instance is not the one that was registered, but rather is
     * proxied.
     *
     */
    public static <T> Conversion<T> to(final Class<T> type) {

	/**
	 * Proxies type conversion to allow for the fact that the value may
	 * provide its own conversion and other subtleties. The goal is to
	 * preserve the identical behavior as if {@link #asType(Class,Object)}
	 * were called.
	 *
	 */
	return new Conversion<T>() {

	    @Override
	    public Object[] getTypeKeys() {
		final Conversion<?> conversion = typeConversions.get(type);
		return (conversion != null) ? TypeConverter.getTypeKeys(
			conversion).toArray(new Object[0]) : new Object[0];
	    }

	    @Override
	    public T convert(final Object value) {
		return TypeConverter.convert(type, value);
	    }
	};
    }

    /**
     * Convert an object to the specified type. A type conversion object must
     * have been previously registered for the provided class in order for the
     * conversion to succeed (with one exception, see below).
     * <p>
     *
     * Value objects that implement {@link Listener} interface will be notified
     * of type conversion via the event methods declared in that interface.
     * Value objects that implement {@link Convertible} will be asked for an
     * instance of {@link Conversion} directly, and the returned object will be
     * used to convert the type instead of the registered type conversion
     * object. These interfaces can be used to customize the type conversion
     * process.
     * <p>
     *
     * Note, this method will check if the provided value is the same as or a
     * subclass of the specified class. If it is, this method returns the value
     * object immediately without attempting to convert its type. One exception
     * to this rule is if the provided type key is {@link Object.class}, in
     * which case the conversion is attempted anyway. The reason for this
     * deviation is that this key may have special meaning based on the type of
     * the provided value. For example, if the provided value is a byte array,
     * the {@link ObjectTypeConversion} class assumes it is a serialized object
     * and attempts to deserialize it. Because all objects, including arrays,
     * are of type {@link Object}, this conversion would never be attempted
     * without this special handling. (Note that the default conversion for type
     * {@link Object.class} is to simply return the original object.)
     *
     * @param type
     *            The target type to which to convert the value
     * @param value
     *            The value to convert to the specified target type
     * @return The converted value object, or <code>null</code> if the original
     *         value is <code>null</code>
     */
    public static <C> C convert(final Class<C> type, final Object value) {
	return (C) convert((Object) type, value);
    }

    /**
     * Convert an object to the type specified by the provided type key. A type
     * conversion object must have been previously registered under the provided
     * key in order for the conversion to succeed (with one exception, see
     * below).
     * <p>
     *
     * Value objects that implement {@link Listener} interface will be notified
     * of type conversion via the event methods declared in that interface.
     * Value objects that implement {@link Convertible} will be asked for an
     * instance of {@link Conversion} directly, and the returned object will be
     * used to convert the type instead of the registered type conversion
     * object. These interfaces can be used to customize the type conversion
     * process.
     * <p>
     *
     * Note, this method treats type keys of type {@link Class} differently than
     * other type keys. That is, this method will check if the provided value is
     * the same as or a subclass of the specified class. If it is, this method
     * returns the value object immediately without attempting to convert its
     * type. One exception to this rule is if the provided type key is {@link
     * Object.class}, in which case the conversion is attempted anyway. The
     * reason for this deviation is that this key may have special meaning based
     * on the type of the provided value. For example, if the provided value is
     * a byte array, the {@link ObjectTypeConversion} class assumes it is a
     * serialized object and attempts to deserialize it. Because all objects,
     * including arrays, are of type {@link Object}, this conversion would never
     * be attempted without this special handling. (Note that the default
     * conversion for type key {@link Object.class} is to simply return the
     * original object.)
     *
     * @param typeKey
     *            The key under which the desired type conversion object has
     *            been previously registered. Most commonly, this key should be
     *            a {@link Class} object, a class name string, or a logical type
     *            string represented by the various <code>TYPE_*</code>
     *            constants defined in this class.
     * @param value
     *            The value to convert to the specified target type
     * @return The converted value object, or <code>null</code> if the original
     *         value is <code>null</code>
     */
    public static Object convert(final Object typeKey, final Object value) {

	// if (value == null) {
	// return null;
	// }

	if (typeKey == null) {
	    return value;
	}

	final Conversion<?> conversion = getTypeConversion(typeKey, value);

	// Convert the value
	if (conversion != null) {
	    if (value instanceof Listener) {
		((Listener) value).beforeConversion(typeKey);
	    }

	    Object result = conversion.convert(value);

	    if (value instanceof Listener) {
		result = ((Listener) value).afterConversion(typeKey, result);
	    }

	    return result;
	} else {
	    throw new IllegalArgumentException("Could not find type "
		    + "conversion for type \"" + typeKey + "\" (value = \""
		    + value + "\")");
	}
    }

    /**
     * Obtain a conversion for the specified type key and value
     *
     */
    private static Conversion<?> getTypeConversion(final Object typeKey,
	    final Object value) {

	// Check if the provided value is already of the target type
	if (typeKey instanceof Class && ((Class) typeKey) != Object.class
		&& ((Class) typeKey).isInstance(value)) {
	    return IDENTITY_CONVERSION;
	}

	// Find the type conversion object
	return (value instanceof Convertible) ? ((Convertible) value)
		.getTypeConversion(typeKey) : typeConversions.get(typeKey);
    }

    /**
     * Return the value converted to a byte
     *
     * @param value
     *            The value to be converted
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static byte asByte(final Object value) {
	return asByte(value, (byte) 0);
    }

    /**
     * Return the value converted to a byte or the specified alternate value if
     * the original value is null. Note, this method still throws
     * {@link IllegalArgumentException} if the value is not null and could not
     * be converted.
     *
     * @param value
     *            The value to be converted
     * @param nullValue
     *            The value to be returned if {@link value} is null. Note, this
     *            value will not be returned if the conversion fails otherwise.
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static byte asByte(Object value, final byte nullValue) {
	value = convert(Byte.class, value);
	if (value != null) {
	    return ((Byte) value).byteValue();
	} else {
	    return nullValue;
	}
    }

    /**
     * Return the value converted to a short
     *
     * @param value
     *            The value to be converted
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static short asShort(final Object value) {
	return asShort(value, (short) 0);
    }

    /**
     * Return the value converted to a short or the specified alternate value if
     * the original value is null. Note, this method still throws
     * {@link IllegalArgumentException} if the value is not null and could not
     * be converted.
     *
     * @param value
     *            The value to be converted
     * @param nullValue
     *            The value to be returned if {@link value} is null. Note, this
     *            value will not be returned if the conversion fails otherwise.
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static short asShort(Object value, final short nullValue) {
	value = convert(Short.class, value);
	if (value != null) {
	    return ((Short) value).shortValue();
	} else {
	    return nullValue;
	}
    }

    /**
     * Return the value converted to an int
     *
     * @param value
     *            The value to be converted
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static int asInt(final Object value) {
	return asInt(value, 0);
    }

    /**
     * Return the value converted to an int or the specified alternate value if
     * the original value is null. Note, this method still throws
     * {@link IllegalArgumentException} if the value is not null and could not
     * be converted.
     *
     * @param value
     *            The value to be converted
     * @param nullValue
     *            The value to be returned if {@link value} is null. Note, this
     *            value will not be returned if the conversion fails otherwise.
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static int asInt(Object value, final int nullValue) {
	value = convert(Integer.class, value);
	if (value != null) {
	    return ((Integer) value).intValue();
	} else {
	    return nullValue;
	}
    }

    /**
     * Return the value converted to a long
     *
     * @param value
     *            The value to be converted
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static long asLong(final Object value) {
	return asLong(value, 0L);
    }

    /**
     * Return the value converted to a long or the specified alternate value if
     * the original value is null. Note, this method still throws
     * {@link IllegalArgumentException} if the value is not null and could not
     * be converted.
     *
     * @param value
     *            The value to be converted
     * @param nullValue
     *            The value to be returned if {@link value} is null. Note, this
     *            value will not be returned if the conversion fails otherwise.
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static long asLong(Object value, final long nullValue) {
	value = convert(Long.class, value);
	if (value != null) {
	    return ((Long) value).longValue();
	} else {
	    return nullValue;
	}
    }

    /**
     * Return the value converted to a float
     *
     * @param value
     *            The value to be converted
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static float asFloat(final Object value) {
	return asFloat(value, 0F);
    }

    /**
     * Return the value converted to a float or the specified alternate value if
     * the original value is null. Note, this method still throws
     * {@link IllegalArgumentException} if the value is not null and could not
     * be converted.
     *
     * @param value
     *            The value to be converted
     * @param nullValue
     *            The value to be returned if {@link value} is null. Note, this
     *            value will not be returned if the conversion fails otherwise.
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static float asFloat(Object value, final float nullValue) {
	value = convert(Float.class, value);
	if (value != null) {
	    return ((Float) value).floatValue();
	} else {
	    return nullValue;
	}
    }

    /**
     * Return the value converted to a double
     *
     * @param value
     *            The value to be converted
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static double asDouble(final Object value) {
	return asDouble(value, 0D);
    }

    /**
     * Return the value converted to a double or the specified alternate value
     * if the original value is null. Note, this method still throws
     * {@link IllegalArgumentException} if the value is not null and could not
     * be converted.
     *
     * @param value
     *            The value to be converted
     * @param nullValue
     *            The value to be returned if {@link value} is null. Note, this
     *            value will not be returned if the conversion fails otherwise.
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static double asDouble(Object value, final double nullValue) {
	value = convert(Double.class, value);
	return (value != null) ? ((Double) value).doubleValue() : nullValue;
    }

    /**
     * Return the value converted to a char
     *
     * @param value
     *            The value to be converted
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static char asChar(final Object value) {
	return asChar(value, (char) 0);
    }

    /**
     * Return the value converted to a char or the specified alternate value if
     * the original value is null. Note, this method still throws
     * {@link IllegalArgumentException} if the value is not null and could not
     * be converted.
     *
     * @param value
     *            The value to be converted
     * @param nullValue
     *            The value to be returned if {@link value} is null. Note, this
     *            value will not be returned if the conversion fails otherwise.
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static char asChar(Object value, final char nullValue) {
	value = convert(Character.class, value);
	return (value != null) ? ((Character) value).charValue() : nullValue;
    }

    /**
     * Return the value converted to a boolean
     *
     * @param value
     *            The value to be converted
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static boolean asBoolean(final Object value) {
	return asBoolean(value, false);
    }

    /**
     * Return the value converted to a boolean or the specified alternate value
     * if the original value is null. Note, this method still throws
     * {@link IllegalArgumentException} if the value is not null and could not
     * be converted.
     *
     * @param value
     *            The value to be converted
     * @param nullValue
     *            The value to be returned if {@link value} is null. Note, this
     *            value will not be returned if the conversion fails otherwise.
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static boolean asBoolean(Object value, final boolean nullValue) {
	value = convert(Boolean.class, value);
	return (value != null) ? ((Boolean) value).booleanValue() : nullValue;
    }

    /**
     * Return the value converted to a string
     *
     * @param value
     *            The value to be converted
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static String asString(final Object value) {
	return convert(String.class, value);
    }

    /**
     * Return the value converted to a string or the specified alternate value
     * if the original value is null. Note, this method still throws
     * {@link IllegalArgumentException} if the value is not null and could not
     * be converted.
     *
     * @param value
     *            The value to be converted
     * @param nullValue
     *            The value to be returned if {@link value} is null. Note, this
     *            value will not be returned if the conversion fails otherwise.
     * @throws IllegalArgumentException
     *             If the value cannot be converted
     */
    public static String asString(Object value, final String nullValue) {
	value = convert(String.class, value);
	return (value != null) ? (String) value : nullValue;
    }

    /**
     * Converts a given value to a specific type
     *
     */
    public static interface Conversion<T> {

	/**
	 * Return the keys under which to register this conversion. This list
	 * should always return the same values to ensure correct behavior.
	 *
	 */
	public Object[] getTypeKeys();

	/**
	 * Converts the provided value to the type represented by the
	 * implementer if this interface
	 *
	 */
	public T convert(Object value);
    }

    /**
     * During type conversion by the {@link TypeConverter} class, value objects
     * that implement this interface will be called upon to provide their own
     * type conversion objects instead of using the conversions registered with
     * the {@link TypeConverter} class.
     *
     */
    public static interface Convertible {

	/**
	 * Provides a custom type conversion object used to convert the type of
	 * this object
	 *
	 * @param targetTypeKey
	 *            The target conversion key, normally a class or String.
	 * @return A type conversion object valid for the specified conversion,
	 *         or null if the {@link TypeConverter} class should attempt to
	 *         use a previously registered type conversion object to convert
	 *         the value of this object.
	 */
	public Conversion<?> getTypeConversion(Object targetTypeKey);
    }

    /**
     * The listener interface for receiving type conversion events. A class that
     * implements this interface will have the event methods in this interface
     * called when that class is being converted by the various conversion
     * methods in the {@link TypeConverter} class.
     *
     */
    public static interface Listener {

	/**
	 * Called before conversion of a value occurs
	 *
	 */
	public void beforeConversion(Object targetTypeKey);

	/**
	 * Called immediately after a conversion of a value occurs, providing
	 * the converted value and giving the listener the opportunity to return
	 * a different value instead
	 *
	 */
	public Object afterConversion(Object targetTypeKey,
		Object convertedValue);
    }

    private static Logger LOG = LoggerFactory.getLogger(TypeConverter.class);

    private static final Map<Object, Conversion<?>> typeConversions = Collections
	    .synchronizedMap(new HashMap<Object, Conversion<?>>());

    /** Logical type name "null" */
    public static final String TYPE_UNKNOWN = "null";

    /** Logical type name "object" */
    public static final String TYPE_OBJECT = "object";

    /** Logical type name "string" */
    public static final String TYPE_STRING = "string";

    /** Logical type name "string" */
    public static final String TYPE_LIST = "list";

    /** Logical type name "int" */
    public static final String TYPE_INT = "int";

    /** Logical type name "integer" */
    public static final String TYPE_INTEGER = "integer";

    /** Logical type name "long" */
    public static final String TYPE_LONG = "long";

    /** Logical type name "float" */
    public static final String TYPE_FLOAT = "float";

    /** Logical type name "double" */
    public static final String TYPE_DOUBLE = "double";

    /** Logical type name "short" */
    public static final String TYPE_SHORT = "short";

    /** Logical type name "boolean" */
    public static final String TYPE_BOOLEAN = "boolean";

    /** Logical type name "byte" */
    public static final String TYPE_BYTE = "byte";

    /** Logical type name "char" */
    public static final String TYPE_CHAR = "char";

    /** Logical type name "character" */
    public static final String TYPE_CHARACTER = "character";

    /** Logical type name "bigdecimal" */
    public static final String TYPE_BIG_DECIMAL = "bigdecimal";

    /** Logical type name "sqldate" */
    public static final String TYPE_SQL_DATE = "sqldate";

    /** Logical type name "sqltime" */
    public static final String TYPE_SQL_TIME = "sqltime";

    /** Logical type name "sqltimestamp" */
    public static final String TYPE_SQL_TIMESTAMP = "sqltimestamp";

    /** Logical type name "groupmembershipenum" */
    public static final Object TYPE_GROUP_MEMBERSHIP_ENUM = "groupmembershipenum";

    /** Logical type name "permissionblastreportenum" */
    public static final Object TYPE_PERMISSION_BLAST_REPORT_ENUM = "permissionblastreportenum";

    /** Logical type name "uuid" */
    public static final Object TYPE_UUID = "uuid";

    private static final Conversion<?> IDENTITY_CONVERSION = new IdentityTypeConversion();

    static {
	// Discover all type conversions on the classpath and register them
	final ServiceLoader<Conversion> loader = ServiceLoader
		.load(Conversion.class);
	for (final Conversion<?> conversion : loader) {
	    registerTypeConversion(conversion);
	}

	if (typeConversions.isEmpty()) {
	    System.err.println("WARNING: No instances of " + Conversion.class
		    + " registered with " + TypeConverter.class);
	}
    }

    public static Object generic(final Object type, final Object from) {
	return generic(type, from, null);
    }

    public static Object generic(final Object type, final Object from,
	    final Object defaultIfNull) {

	if (from != null) {

	    if (from instanceof java.util.ArrayList) {

		List<?> list = (List<?>) from;
		String[] strArray = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
		    strArray[i] = (String) TypeConverter.generic(String.class,
			    list.get(i), null);
		}

		return strArray;

	    } else if (from instanceof String) {

		String fromValue = (String) from;

		if (type.equals(String.class)) {
		    return from;
		} else if (type.equals(Integer.class)) {

		    if (StringUtils.isEmpty(fromValue)) {
			return null;
		    } else {

			return Integer.parseInt(fromValue);
		    }

		} else if (type.equals(BigDecimal.class)) {

		    if (StringUtils.isEmpty(fromValue)) {
			return null;
		    } else {
			// Some value contains comma instead of decimals
			fromValue = fromValue.replaceAll(",", ".");
			return new BigDecimal(fromValue);
		    }

		} else if (type.equals(Float.class)) {

		    if (StringUtils.isEmpty(fromValue)) {
			return null;
		    } else {

			return Float.parseFloat(fromValue);
		    }

		} else if (type.equals(Double.class)) {

		    if (StringUtils.isEmpty(fromValue)) {
			return null;
		    } else {

			return Float.parseFloat(fromValue);
		    }

		} else if (type.equals(Boolean.class)
			|| type.equals(boolean.class)) {

		    if (fromValue.equalsIgnoreCase("ON")) {
			fromValue = "true";
		    }

		    if (fromValue.equalsIgnoreCase("OFF")) {
			fromValue = "false";
		    }

		    return Boolean.parseBoolean(fromValue);

		} else if (type.equals(List.class)) {

		    return convertToListOfString(fromValue);

		} else if (type.equals(Float.class)) {

		    if (StringUtils.isEmpty(fromValue)) {
			return null;
		    } else {
			return Float.parseFloat(fromValue);
		    }

		} else if (type.equals(GroupMemberShipEnum.class)) {
		    if (StringUtils.isEmpty(fromValue)) {
			return null;
		    } else {

			return GroupMemberShipEnum.valueOf(fromValue);
		    }

		} else if (type.equals(PermissionBlastReportEnum.class)) {
		    if (StringUtils.isEmpty(fromValue)) {
			return null;
		    } else {

			return PermissionBlastReportEnum.valueOf(fromValue);
		    }
		} else if (type.equals(UUID.class)) {

		    if (StringUtils.isEmpty(fromValue)) {
			return null;
		    } else {
			return UUID.fromString(fromValue);
		    }
		} else if (type.equals(Date.class)) {

		    if (StringUtils.isEmpty(fromValue)) {
			return null;
		    } else {

			try {

			    Date date = new Date(Long.parseLong(fromValue));
			    return date;

			} catch (Exception ex) {

			    final DateFormat format = new SimpleDateFormat(
				    "yyyy-MM-dd");

			    Date date = null;
			    try {
				date = format.parse(fromValue);
			    } catch (final ParseException e) {
				e.printStackTrace();
			    }

			    return date;
			}
		    }

		} else if (((Class) type).getCanonicalName().equals(
			boolean.class.getCanonicalName())) {
		    // Try to the best to convert
		    // Using TypeConverter.convert(type, from) in this case
		    // returns always true! Don't use it
		    if (((String) from).trim().equalsIgnoreCase("TRUE")
			    || ((String) from).trim().equalsIgnoreCase("ON")) {
			return true;
		    } else {
			// Otherwise always false
			return false;
		    }
		}

	    } else {
		return TypeConverter.convert(type, from);
	    }
	}

	else {
	    if (((Class) type).getCanonicalName().equals(
		    Boolean.class.getCanonicalName())) {
		// Having defaultIfNull set to NULL will return a Boolean Object
		// to NULL
		return TypeConverter.convert(type, defaultIfNull);
	    } else if (((Class) type).getCanonicalName().equals(
		    boolean.class.getCanonicalName())) {
		if (defaultIfNull == null) {
		    // Having defaultIfNull set to NULL but the the type is a
		    // primitive boolean, set to a primitive false
		    return false;
		} else {
		    // Having defaultIfNull set to NULL will return a Boolean
		    // Object or primitive
		    // to NULL
		    return TypeConverter.convert(type, defaultIfNull);
		}
	    } else {
		return TypeConverter.convert(type, defaultIfNull);
	    }
	}

	LOG.error("No converter where found for Class type : "
		+ (type.getClass().getName()));

	return defaultIfNull;
    }

    private static List<String> convertToListOfString(final String s) {
	final List<String> tokens = new ArrayList<String>();

	String delimiter = ",";

	if (s.contains("\n")) {
	    delimiter = "\n";
	}
	final StringTokenizer st = new StringTokenizer(s, delimiter);
	while (st.hasMoreTokens()) {
	    // get the next token and remove whitespace
	    // String token = st.nextToken().replaceAll("\\s","");
	    final String token = st.nextToken().replaceAll("[\\r\\n]", "");

	    if (!token.equalsIgnoreCase("")) {
		tokens.add(token);
	    }
	}
	return tokens;
    }
}
