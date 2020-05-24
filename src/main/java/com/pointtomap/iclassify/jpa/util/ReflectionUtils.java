package com.pointtomap.iclassify.jpa.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import com.esotericsoftware.minlog.Log;
import com.toddfast.util.convert.TypeConverter;

/**
 * @author stlouisa
 *
 */
/**
 * @author stlouisa
 *
 */
public class ReflectionUtils {

	public static void cloneSkipNull(final Object fromObj, final Object toObj, String[] excludedProperties) {

		if (fromObj.getClass() != toObj.getClass()) {

			throw new RuntimeException("Source  and Destination class are incompatible, using the cloneLoosy");

		}

		String fieldNameProcessing = "";

		if (excludedProperties == null) {
			excludedProperties = new String[0];
		}

		final Class<? extends Object> fromClass = fromObj.getClass();
		final Class<? extends Object> toClass = toObj.getClass();

		try {
			final BeanInfo fromBean = Introspector.getBeanInfo(fromClass);
			final BeanInfo toBean = Introspector.getBeanInfo(toClass);
			final PropertyDescriptor[] toPd = toBean.getPropertyDescriptors();
			final List<PropertyDescriptor> fromPd = Arrays.asList(fromBean.getPropertyDescriptors());
			for (final PropertyDescriptor propertyDescriptor : toPd) {
				propertyDescriptor.getDisplayName();

				final PropertyDescriptor pd = fromPd.indexOf(propertyDescriptor) >= 0
						? fromPd.get(fromPd.indexOf(propertyDescriptor))
						: null;

				if (pd != null && pd.getDisplayName().equals(propertyDescriptor.getDisplayName())
						&& !pd.getDisplayName().equals("class")
						&& !Arrays.asList(excludedProperties).contains(pd.getDisplayName())) {
					if (propertyDescriptor.getWriteMethod() != null) {
						fieldNameProcessing = pd.getName();

						// If either the Read or Write method has this
						// annotation, it will be skipped
						final boolean hasReaderMethodSkipCloneAnnocationPresent = (pd.getReadMethod() == null ? false
								: pd.getReadMethod().isAnnotationPresent(ReflectionDontClone.class));
						final boolean hasWriterMethodSkipCloneAnnocationPresent = propertyDescriptor.getWriteMethod()
								.isAnnotationPresent(ReflectionDontClone.class);

						if (!hasReaderMethodSkipCloneAnnocationPresent && !hasWriterMethodSkipCloneAnnocationPresent) {

							Object o = null;
							if (pd.getReadMethod() != null) {
								o = pd.getReadMethod().invoke(fromObj);
							}

							// Only replace the value in the attached object if
							// not
							// null
							if (o != null) {
								propertyDescriptor.getWriteMethod().invoke(toObj, pd.getReadMethod().invoke(fromObj));
							}
						}
					}
				}
			}
		} catch (final IntrospectionException e) {
			Log.error("ReflectionUtils.cloneSkipNull cannot introspec exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final IllegalArgumentException e) {
			Log.error("ReflectionUtils.cloneSkipNull got a illegal argument exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			Log.error("ReflectionUtils.cloneSkipNull got a illegal access exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final InvocationTargetException e) {
			Log.error("ReflectionUtils.cloneSkipNull got a innovation target exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		}
	}

	public static void clone(final Object fromObj, final Object toObj, String[] excludedProperties) {

		if (fromObj.getClass().getSuperclass().getCanonicalName().equals(toObj.getClass().getCanonicalName())) {

			throw new RuntimeException(
					"Source  and Destination class are incompatible, you should use the cloneLoosy method");

		}

		String fieldNameProcessing = "";

		if (excludedProperties == null) {
			excludedProperties = new String[0];
		}

		final Class<? extends Object> fromClass = fromObj.getClass();
		final Class<? extends Object> toClass = toObj.getClass();

		try {
			final BeanInfo fromBean = Introspector.getBeanInfo(fromClass);
			final BeanInfo toBean = Introspector.getBeanInfo(toClass);

			final PropertyDescriptor[] toPd = toBean.getPropertyDescriptors();
			final List<PropertyDescriptor> fromPd = Arrays.asList(fromBean.getPropertyDescriptors());

			for (final PropertyDescriptor propertyDescriptor : toPd) {
				propertyDescriptor.getDisplayName();

				PropertyDescriptor pd = null;

				// final PropertyDescriptor pd = fromPd
				// .indexOf(propertyDescriptor) >= 0 ? fromPd.get(fromPd
				// .indexOf(propertyDescriptor)) : null;
				//

				for (int i = 0; i < fromPd.size(); i++) {
					if (fromPd.get(i).getName().equals(propertyDescriptor.getName())) {
						pd = fromPd.get(i);

						break;
					}
				}

				if (pd != null && pd.getDisplayName().equals(propertyDescriptor.getDisplayName())
						&& !pd.getDisplayName().equals("class")
						&& !Arrays.asList(excludedProperties).contains(pd.getDisplayName())) {
					if (propertyDescriptor.getWriteMethod() != null) {
						fieldNameProcessing = pd.getName();
						// If either the Read or Write method has this
						// annotation, it will be skipped
						final boolean hasReaderMethodSkipCloneAnnocationPresent = (pd.getReadMethod() == null ? false
								: pd.getReadMethod().isAnnotationPresent(ReflectionDontClone.class));
						final boolean hasWriterMethodSkipCloneAnnocationPresent = propertyDescriptor.getWriteMethod()
								.isAnnotationPresent(ReflectionDontClone.class);

						if (!hasReaderMethodSkipCloneAnnocationPresent && !hasWriterMethodSkipCloneAnnocationPresent) {

							if (pd.getReadMethod() != null) {
								pd.getReadMethod().invoke(fromObj);
							}

							propertyDescriptor.getWriteMethod().invoke(toObj, pd.getReadMethod().invoke(fromObj));
						}
					}
				}
			}
		} catch (final IntrospectionException e) {
			Log.error("ReflectionUtils.clone cannot introspec exception with field name '" + "'" + fieldNameProcessing);
			e.printStackTrace();
		} catch (final IllegalArgumentException e) {
			Log.error("ReflectionUtils.clone got a illegal argument exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			Log.error("ReflectionUtils.clone got a illegal access exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final InvocationTargetException e) {
			Log.error("ReflectionUtils.clone got a innovation target exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final NullPointerException e) {
			Log.error("ReflectionUtils.clone got a innovation target exception with field name '" + "'" + fromClass);
			e.printStackTrace();
		}
	}

	public static void cloneLoosy(final Object fromObj, final Object toObj, String[] excludedProperties) {

		if (fromObj.getClass() == toObj.getClass()) {

			throw new RuntimeException(
					"Source  and Destination class are compatible use the clone instead of cloneLoosy");
		}

		String fieldNameProcessing = "";

		if (excludedProperties == null) {
			excludedProperties = new String[0];
		}

		final Class<? extends Object> fromClass = fromObj.getClass();
		final Class<? extends Object> toClass = toObj.getClass();

		try {
			final BeanInfo fromBean = Introspector.getBeanInfo(fromClass);
			final BeanInfo toBean = Introspector.getBeanInfo(toClass);
			final PropertyDescriptor[] toPd = toBean.getPropertyDescriptors();
			final List<PropertyDescriptor> fromPd = Arrays.asList(fromBean.getPropertyDescriptors());
			for (final PropertyDescriptor propertyDescriptor : toPd) {
				propertyDescriptor.getDisplayName();

				PropertyDescriptor pd = null;

				for (int i = 0; i < fromPd.size(); i++) {
					if (fromPd.get(i).getName().equals(propertyDescriptor.getName())) {
						pd = fromPd.get(i);

						break;
					}
				}

				if (pd != null && pd.getDisplayName().equals(propertyDescriptor.getDisplayName())
						&& !pd.getDisplayName().equals("class")
						&& !Arrays.asList(excludedProperties).contains(pd.getDisplayName())) {
					if (propertyDescriptor.getWriteMethod() != null) {
						fieldNameProcessing = pd.getName();

						// If either the Read or Write method has this
						// annotation, it will be skipped
						final boolean hasReaderMethodSkipCloneAnnocationPresent = (pd.getReadMethod() == null ? false
								: pd.getReadMethod().isAnnotationPresent(ReflectionDontClone.class));
						final boolean hasWriterMethodSkipCloneAnnocationPresent = propertyDescriptor.getWriteMethod()
								.isAnnotationPresent(ReflectionDontClone.class);

						if (!hasReaderMethodSkipCloneAnnocationPresent && !hasWriterMethodSkipCloneAnnocationPresent) {

							if (pd.getReadMethod() != null) {
								pd.getReadMethod().invoke(fromObj);
							}

							propertyDescriptor.getWriteMethod().invoke(toObj, pd.getReadMethod().invoke(fromObj));
						}
					}
				}
			}
		} catch (final IntrospectionException e) {
			Log.error("ReflectionUtils.cloneLoosy cannot introspec exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final IllegalArgumentException e) {
			Log.error("ReflectionUtils.cloneLoosy got a illegal argument exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			Log.error("ReflectionUtils.cloneLoosy got a illegal access exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final InvocationTargetException e) {
			Log.error("ReflectionUtils.cloneLoosy got a innovation target exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		}
	}

	public static void cloneLoosySkipNull(final Object fromObj, final Object toObj, String[] excludedProperties) {

		if (fromObj.getClass() == toObj.getClass()) {

			throw new RuntimeException(
					"Source  and Destination class are compatible use the clone instead of cloneLoosy");
		}

		String fieldNameProcessing = "";

		if (excludedProperties == null) {
			excludedProperties = new String[0];
		}

		final Class<? extends Object> fromClass = fromObj.getClass();
		final Class<? extends Object> toClass = toObj.getClass();

		try {
			final BeanInfo fromBean = Introspector.getBeanInfo(fromClass);
			final BeanInfo toBean = Introspector.getBeanInfo(toClass);
			final PropertyDescriptor[] toPd = toBean.getPropertyDescriptors();
			final List<PropertyDescriptor> fromPd = Arrays.asList(fromBean.getPropertyDescriptors());
			for (final PropertyDescriptor propertyDescriptor : toPd) {
				propertyDescriptor.getDisplayName();

				PropertyDescriptor pd = null;

				for (int i = 0; i < fromPd.size(); i++) {
					if (fromPd.get(i).getName().equals(propertyDescriptor.getName())) {
						pd = fromPd.get(i);

						break;
					}
				}

				if (pd != null && pd.getDisplayName().equals(propertyDescriptor.getDisplayName())
						&& !pd.getDisplayName().equals("class")
						&& !Arrays.asList(excludedProperties).contains(pd.getDisplayName())) {
					if (propertyDescriptor.getWriteMethod() != null) {
						fieldNameProcessing = pd.getName();

						// If either the Read or Write method has this
						// annotation, it will be skipped
						final boolean hasReaderMethodSkipCloneAnnocationPresent = (pd.getReadMethod() == null ? false
								: pd.getReadMethod().isAnnotationPresent(ReflectionDontClone.class));
						final boolean hasWriterMethodSkipCloneAnnocationPresent = propertyDescriptor.getWriteMethod()
								.isAnnotationPresent(ReflectionDontClone.class);

						if (!hasReaderMethodSkipCloneAnnocationPresent && !hasWriterMethodSkipCloneAnnocationPresent) {

							if (pd.getReadMethod() != null) {
								pd.getReadMethod().invoke(fromObj);
							}

							if (pd.getReadMethod().invoke(fromObj) != null) {
								propertyDescriptor.getWriteMethod().invoke(toObj, pd.getReadMethod().invoke(fromObj));
							}
						}
					}
				}
			}
		} catch (final IntrospectionException e) {
			Log.error("ReflectionUtils.cloneLoosy cannot introspec exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final IllegalArgumentException e) {
			Log.error("ReflectionUtils.cloneLoosy got a illegal argument exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			Log.error("ReflectionUtils.cloneLoosy got a illegal access exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final InvocationTargetException e) {
			Log.error("ReflectionUtils.cloneLoosy got a innovation target exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		}
	}

	public static void cloneLoosyAutoConversion(final Object fromObj, final Object toObj, String[] excludedProperties) {

		if (fromObj.getClass() == toObj.getClass()) {

			throw new RuntimeException(
					"Source  and Destination class are compatible use the clone instead of cloneLoosy");
		}

		String fieldNameProcessing = "";

		if (excludedProperties == null) {
			excludedProperties = new String[0];
		}

		final Class<? extends Object> fromClass = fromObj.getClass();
		final Class<? extends Object> toClass = toObj.getClass();

		try {
			final BeanInfo fromBean = Introspector.getBeanInfo(fromClass);
			final BeanInfo toBean = Introspector.getBeanInfo(toClass);
			final PropertyDescriptor[] toPd = toBean.getPropertyDescriptors();
			final List<PropertyDescriptor> fromPd = Arrays.asList(fromBean.getPropertyDescriptors());
			for (final PropertyDescriptor propertyDescriptor : toPd) {
				propertyDescriptor.getDisplayName();

				PropertyDescriptor pd = null;

				for (int i = 0; i < fromPd.size(); i++) {
					if (fromPd.get(i).getName().equals(propertyDescriptor.getName())) {
						pd = fromPd.get(i);

						break;
					}
				}

				if (pd != null && pd.getDisplayName().equals(propertyDescriptor.getDisplayName())
						&& !pd.getDisplayName().equals("class")
						&& !Arrays.asList(excludedProperties).contains(pd.getDisplayName())) {
					if (propertyDescriptor.getWriteMethod() != null) {
						fieldNameProcessing = pd.getName();

						// If either the Read or Write method has this
						// annotation, it will be skipped
						final boolean hasReaderMethodSkipCloneAnnocationPresent = (pd.getReadMethod() == null ? false
								: pd.getReadMethod().isAnnotationPresent(ReflectionDontClone.class));
						final boolean hasWriterMethodSkipCloneAnnocationPresent = propertyDescriptor.getWriteMethod()
								.isAnnotationPresent(ReflectionDontClone.class);

						if (!hasReaderMethodSkipCloneAnnocationPresent && !hasWriterMethodSkipCloneAnnocationPresent) {

							Object o = null;
							if (pd.getReadMethod() != null) {
								o = pd.getReadMethod().invoke(fromObj);
							}

							propertyDescriptor.getWriteMethod().invoke(toObj,
									TypeConverter.generic(propertyDescriptor.getPropertyType(), o));
						}
					}
				}
			}
		} catch (final IntrospectionException e) {
			Log.error("ReflectionUtils.cloneLoosy cannot introspec exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final IllegalArgumentException e) {
			Log.error("ReflectionUtils.cloneLoosy got a illegal argument exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			Log.error("ReflectionUtils.cloneLoosy got a illegal access exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final InvocationTargetException e) {
			Log.error("ReflectionUtils.cloneLoosy got a innovation target exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		}
	}

	public static void clone(final Object srcObj, final Object dstObj) {

		clone(srcObj, dstObj, null);

	}

	public static void cloneLoosy(final Object srcObj, final Object dstObj) {

		cloneLoosy(srcObj, dstObj, null);

	}

	public static void cloneLoosyAutoConversion(final Object srcObj, final Object dstObj) {

		cloneLoosyAutoConversion(srcObj, dstObj, null);

	}

	/*
	 * Clone Structure A in B only looking at String properties. if the source is
	 * not null and the destination is not null, append the string a into B and
	 * separate with comma.
	 */

	public static void cloneAppend(final Object fromObj, final Object toObj, String[] excludedProperties) {

		if (fromObj.getClass().getSuperclass().getCanonicalName().equals(toObj.getClass().getCanonicalName())) {

			throw new RuntimeException(
					"Source  and Destination class are incompatible, you should use the cloneLoosy method");

		}

		String fieldNameProcessing = "";

		if (excludedProperties == null) {
			excludedProperties = new String[0];
		}

		final Class<? extends Object> fromClass = fromObj.getClass();
		final Class<? extends Object> toClass = toObj.getClass();

		try {
			final BeanInfo fromBean = Introspector.getBeanInfo(fromClass);
			final BeanInfo toBean = Introspector.getBeanInfo(toClass);

			final PropertyDescriptor[] toPd = toBean.getPropertyDescriptors();
			final List<PropertyDescriptor> fromPd = Arrays.asList(fromBean.getPropertyDescriptors());

			for (final PropertyDescriptor propertyDescriptor : toPd) {
				propertyDescriptor.getDisplayName();

				PropertyDescriptor pd = null;

				// final PropertyDescriptor pd = fromPd
				// .indexOf(propertyDescriptor) >= 0 ? fromPd.get(fromPd
				// .indexOf(propertyDescriptor)) : null;
				//
				for (int i = 0; i < fromPd.size(); i++) {
					if (fromPd.get(i).getName().equals(propertyDescriptor.getName())) {
						pd = fromPd.get(i);

						break;
					}
				}

				if (pd != null && pd.getDisplayName().equals(propertyDescriptor.getDisplayName())
						&& !pd.getDisplayName().equals("class")
						&& !Arrays.asList(excludedProperties).contains(pd.getDisplayName())) {
					if (propertyDescriptor.getWriteMethod() != null) {
						fieldNameProcessing = pd.getName();
						// If either the Read or Write method has this
						// annotation, it will be skipped
						final boolean hasReaderMethodSkipCloneAnnocationPresent = (pd.getReadMethod() == null ? false
								: pd.getReadMethod().isAnnotationPresent(ReflectionDontClone.class));
						final boolean hasWriterMethodSkipCloneAnnocationPresent = propertyDescriptor.getWriteMethod()
								.isAnnotationPresent(ReflectionDontClone.class);

						if (!hasReaderMethodSkipCloneAnnocationPresent && !hasWriterMethodSkipCloneAnnocationPresent) {

							if (pd.getReadMethod() != null) {
								pd.getReadMethod().invoke(fromObj);
							}

							Class<?> type = propertyDescriptor.getPropertyType();

							if (String.class.isAssignableFrom(type)) {

								String label = (String) pd.getReadMethod().invoke(toObj);

								String newLabel = (String) propertyDescriptor.getReadMethod().invoke(fromObj);

								if (label == null) {
									label = "";
								}

								if (newLabel == null) {
									newLabel = "";
								}

								String concate = addWithoutDup(label, newLabel);

								propertyDescriptor.getWriteMethod().invoke(toObj, concate);
							}
						}
					}
				}
			}
		} catch (final IntrospectionException e) {
			Log.error("ReflectionUtils.clone cannot introspec exception with field name '" + "'" + fieldNameProcessing);
			e.printStackTrace();
		} catch (final IllegalArgumentException e) {
			Log.error("ReflectionUtils.clone got a illegal argument exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			Log.error("ReflectionUtils.clone got a illegal access exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final InvocationTargetException e) {
			Log.error("ReflectionUtils.clone got a innovation target exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		}
	}

	/*
	 * Clone Structure A in B only looking at the boolean properties. if the source
	 * is true and the destination is false replace the destination, otherwise
	 * ignore.
	 */
	public static void cloneBooleanTrue(final Object fromObj, final Object toObj, String[] excludedProperties) {

		if (fromObj.getClass().getSuperclass().getCanonicalName().equals(toObj.getClass().getCanonicalName())) {

			throw new RuntimeException(
					"Source  and Destination class are incompatible, you should use the cloneLoosy method");

		}

		String fieldNameProcessing = "";

		if (excludedProperties == null) {
			excludedProperties = new String[0];
		}

		final Class<? extends Object> fromClass = fromObj.getClass();
		final Class<? extends Object> toClass = toObj.getClass();

		try {
			final BeanInfo fromBean = Introspector.getBeanInfo(fromClass);
			final BeanInfo toBean = Introspector.getBeanInfo(toClass);

			final PropertyDescriptor[] toPd = toBean.getPropertyDescriptors();
			final List<PropertyDescriptor> fromPd = Arrays.asList(fromBean.getPropertyDescriptors());

			for (final PropertyDescriptor propertyDescriptor : toPd) {
				propertyDescriptor.getDisplayName();

				PropertyDescriptor pd = null;

				// final PropertyDescriptor pd = fromPd
				// .indexOf(propertyDescriptor) >= 0 ? fromPd.get(fromPd
				// .indexOf(propertyDescriptor)) : null;
				//

				for (int i = 0; i < fromPd.size(); i++) {
					if (fromPd.get(i).getName().equals(propertyDescriptor.getName())) {
						pd = fromPd.get(i);

						break;
					}
				}

				if (pd != null && pd.getDisplayName().equals(propertyDescriptor.getDisplayName())
						&& !pd.getDisplayName().equals("class")
						&& !Arrays.asList(excludedProperties).contains(pd.getDisplayName())) {
					if (propertyDescriptor.getWriteMethod() != null) {
						fieldNameProcessing = pd.getName();
						// If either the Read or Write method has this
						// annotation, it will be skipped
						final boolean hasReaderMethodSkipCloneAnnocationPresent = (pd.getReadMethod() == null ? false
								: pd.getReadMethod().isAnnotationPresent(ReflectionDontClone.class));
						final boolean hasWriterMethodSkipCloneAnnocationPresent = propertyDescriptor.getWriteMethod()
								.isAnnotationPresent(ReflectionDontClone.class);

						if (!hasReaderMethodSkipCloneAnnocationPresent && !hasWriterMethodSkipCloneAnnocationPresent) {

							Class<?> type = propertyDescriptor.getPropertyType();

							if (boolean.class.isAssignableFrom(type)) {

								Boolean currentState = (Boolean) pd.getReadMethod().invoke(toObj);

								if (currentState == null) {
									currentState = false;
								}

								Boolean newState = (Boolean) propertyDescriptor.getReadMethod().invoke(fromObj);

								if (newState) {
									propertyDescriptor.getWriteMethod().invoke(toObj, newState);
								}
							}
						}
					}
				}
			}
		} catch (final IntrospectionException e) {
			Log.error("ReflectionUtils.clone cannot introspec exception with field name '" + "'" + fieldNameProcessing);
			e.printStackTrace();
		} catch (final IllegalArgumentException e) {
			Log.error("ReflectionUtils.clone got a illegal argument exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			Log.error("ReflectionUtils.clone got a illegal access exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		} catch (final InvocationTargetException e) {
			Log.error("ReflectionUtils.clone got a innovation target exception with field name '" + "'"
					+ fieldNameProcessing);
			e.printStackTrace();
		}
	}

	static private String addWithoutDup(String src, String newLabel) {

		if (src.indexOf(newLabel) < 0) {
			return src + ", " + newLabel;
		} else {
			return src;
		}

	}

}
