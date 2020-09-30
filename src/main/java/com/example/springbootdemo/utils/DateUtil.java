/*
 * Copyright © 2016 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.example.springbootdemo.utils;

import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.util.CollectionUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间工具类 Created by hukaiyang on 2016/3/24.
 */
public class DateUtil {
	/**
	 * 时间戳格式化为日期时间 日期时间格式yyyy-MM-dd HH:mm:ss
	 */
	public static String formatDatetime(Long stamp) {
		if (stamp == null) {
			return "";
		} else {
			final Date date = new Date(stamp);
			return FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(date);
		}
	}

	/**
	 * 格式化日期 日期格式yyyy-MM-dd
	 */
	public static String formatForDate(Long stamp) {
		if (stamp == null) {
			return "";
		} else {
			final Date date = new Date(stamp);
			return FastDateFormat.getInstance("yyyy-MM-dd").format(date);
		}
	}

	/**
	 * 格式化日期 日期格式yyyy-MM-dd
	 */
	public static String formatForDate(Date date) {
		if (date == null) {
			return "";
		} else {
			return FastDateFormat.getInstance("yyyy-MM-dd").format(date);
		}
	}

	/**
	 * 格式化日期时间 日期时间格式yyyy-MM-dd HH:mm:ss
	 */
	public static String formatDatetime(Date date) {
		if (date == null) {
			return "";
		} else {
			return FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(date);
		}
	}
	
	/**
	 * 格式化日期时间 日期时间格式yyyy-MM-dd HH:mm:ss
	 */
	public static List<String> formatDatetime(List<Date> dateList) {
		final List<String> dates = new ArrayList<>();
		if (!CollectionUtils.isEmpty(dateList)) {
			dateList.forEach(date -> dates.add(DateUtil.formatDatetime(date)));
		}
		return dates;
	}
	
	/**
	 * 格式化日期时间 日期时间格式yyyy-MM-dd HH:mm:ss
	 */
	public static String formatMonthDatetime(Date date) {
		if (date == null) {
			return "";
		} else {
			return FastDateFormat.getInstance("MM-dd HH:mm").format(date);
		}
	}
	
	/**
	 * 获得当前时间的java.util.Date对象
	 * @return 字符串形式的当前时间
	 */
	public static String getCurrentDatetime() {
		return FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	/**
	 * 格式化过的时间类型转Date
	 */
	public static Date stringParseToDate(String time) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			if (null != time && !"".equals(time)) {
				date = format.parse(time);
			}
		} catch (ParseException e) {
			throw new RuntimeException("转换日期失败", new Throwable(e));
		}
		return date;
	}

	/**
	 * 格式化过的时间类型转Date
	 */
	public static Date stringParseToDate(String time,String formatStr) {
		DateFormat format = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			if (null != time && !"".equals(time)) {
				date = format.parse(time);
			}
		} catch (ParseException e) {
			throw new RuntimeException("转换日期失败", new Throwable(e));
		}
		return date;
	}


	/**
	 * 格式化过的时间类型转Date
	 */
	public static Date stringFormatToDate(String time) {
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date date = null;
		try {
			if (null != time && !"".equals(time)) {
				date = format.parse(time);
			}
		} catch (ParseException e) {
		}
		return date;
	}

	/**
	 * 格式化过的时间类型转Date
	 */
	public static Date stringForToDate(String time) {
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = null;
		try {
			if (null != time && !"".equals(time)) {
				date = format.parse(time);
			}
		} catch (ParseException e) {
		}
		return date;
	}
	
	/**
	 * 格式化日期 日期格式yyyy/MM/dd
	 */
	public static String formatDate(Date date) {
		if (date == null) {
			return "";
		} else {
			return FastDateFormat.getInstance("yyyy/MM/dd").format(date);
		}
	}
	
	/**
	 * 格式化时间 时间格式HH:mm:ss
	 */
	public static String formatTime(Date date) {
		return FastDateFormat.getInstance("HH:mm:ss").format(date);
	}
	
	/**
	 * xxxx年xx月xx日 xx:xx:xx
	 */
	public static String formatDatetimeWithChinese(Date date) {
		return FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(date);
	}
	
	public static boolean dayCompareTo(final Date nowDate, final Date when) {
		final Date begin = DateUtil.dayEnd(nowDate);
		final Date end = DateUtil.dayEnd(when);
		return end.before(begin);
	}
	
	/**
	 * 获取date往后 N 个月的日期对象
	 * @param date 时间
	 * @param monthNum 可以为负数
	 */
	public static Date addMonthNum(Date date, int monthNum) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, monthNum);
		return calendar.getTime();
	}
	
	/**
	 * 获取date往后 N 个天的日期对象
	 * @param date 时间
	 * @param dayNum 可以为负数
	 */
	public static Date addDayNum(Date date, Integer dayNum) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, dayNum);
		return calendar.getTime();
	}
	
	/**
	 * 获取date往后 N 个天的日期对象
	 * @param date 时间
	 * @param dayNum 可以为负数
	 */
	public static Date addBeginDayNum(Date date, Integer dayNum) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.DAY_OF_YEAR, dayNum);
		return calendar.getTime();
	}
	
	/**
	 * 获取date往后hourNum小时的一个日期对象
	 * @param date 时间
	 * @param hourNum 小时数
	 */
	public static Date addHourNum(Date date, int hourNum) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hourNum);
		return calendar.getTime();
	}
	
	/**
	 * 取某一天的最后一刻
	 * @param date 时间
	 */
	public static Date dayEnd(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	/**
	 * 取某一天的最开始一刻
	 * @param date 时间
	 */
	public static Date dayBegin(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 统计一个时间集合中与当前时间连续的天数
	 * @param dateList 时间集合
	 * @param dateNow 当前时间
	 */
	public static int continualDayCount(final List<Date> dateList, final Date dateNow) {
		int count = 0;
		if (CollectionUtils.isEmpty(dateList)) {
			return count;
		}
		final String dateNowStr = DateUtil.formatDate(dateNow);
		dateList.sort(Comparator.reverseOrder());
		final Date nowDay = DateUtil.addDayNum(dateList.get(0), 1);
		final boolean isYesterday = dateNowStr.equals(DateUtil.formatDate(nowDay));
		final int dateCount = dateList.size();
		for (int i = 0; i < dateCount; i++) {
			final Date date = dateList.get(i);
			final String dateStr = DateUtil.formatDate(date);
			if (0 == count) {
				if (dateNowStr.equals(dateStr) || isYesterday) {
					count++;
				} else {
					break;
				}
			} else {
				Date nextDay = null;
				if (isYesterday && dateCount >= i + 1) {
					nextDay = DateUtil.addDayNum(date, i + 1);
				} else {
					nextDay = DateUtil.addDayNum(date, i);
				}
				final String nextDayStr = DateUtil.formatDate(nextDay);
				if (!dateNowStr.equals(nextDayStr)) {
					break;
				}
				count++;
			}
		}
		return count;
	}
	
	/**
	 * 计算两个日期之间相差的天数,当天数小于或等于0时返回1
	 * @param beginDate 较小的时间
	 * @param endDate 较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date beginDate, Date endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			beginDate = sdf.parse(sdf.format(beginDate));
			endDate = sdf.parse(sdf.format(endDate));
		} catch (ParseException e) {
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(beginDate);
		long beginTime = cal.getTimeInMillis();
		cal.setTime(endDate);
		long endTime = cal.getTimeInMillis();
		long betweenDays = (endTime - beginTime) / (1000 * 3600 * 24);
		int betweenDay = Integer.valueOf(String.valueOf(betweenDays));
		return betweenDay + 1;
	}
	
	public static String getMonthFirstDay() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		return formatDatetime(c.getTime());
	}
}
