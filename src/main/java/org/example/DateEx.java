package org.example;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateEx {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        final long time = date.getTime();
        Calendar calendar = new GregorianCalendar();
        final SimpleDateFormat dateFormat = new SimpleDateFormat();

        Thread.sleep(1000 * 3);
        Date adate = new Date();
        System.out.println("date = " + adate);
        adate.setTime(time);
        System.out.println("adate = " + adate);
        //Duration(시간 기반), Period(날짜 기반)

        final Instant instant = Instant.now();
        System.out.println("instant = " + instant);
        System.out.println(instant.atZone(ZoneId.of("UTC")));

        final ZoneId zone = ZoneId.systemDefault();
        System.out.println("zone = " + zone);
        final ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println("zonedDateTime = " + zonedDateTime);

        final LocalDateTime now = LocalDateTime.now();
        System.out.println("LocalDate = " + now);
        final LocalDateTime bir = LocalDateTime.of(1991, Month.JUNE, 12, 0, 0);
        System.out.println("bir = " + bir);
        final ZonedDateTime america = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println("america = " + america);

        final LocalDate today = LocalDate.now();
        final LocalDate thisYearMyBirthday = LocalDate.of(2023, Month.JUNE, 12);

        //생일까지 얼마 남았는지 확인 방법 1 (Period는 사람이 알아볼수 있는 용도)
        final Period period = Period.between(today, thisYearMyBirthday);
        System.out.println(period.getDays());

        //생일까지 얼마 남았는지 확인 방법 2
        final Period until = today.until(thisYearMyBirthday);
        System.out.println(until.get(ChronoUnit.DAYS));

        System.out.println("================");
        //Duration 머신용 시간비교
        final Instant now1 = Instant.now();
        final Instant plus = now1.plus(10, ChronoUnit.SECONDS);
        final Duration between = Duration.between(now1, plus);
        System.out.println(between.getSeconds());

        System.out.println("=================");
        final LocalDateTime now2 = LocalDateTime.now();
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now2.format(dateTimeFormatter));

        final LocalDate parse = LocalDate.parse("07/15/1991", dateTimeFormatter);
        System.out.println("parse = " + parse);
    }
}
