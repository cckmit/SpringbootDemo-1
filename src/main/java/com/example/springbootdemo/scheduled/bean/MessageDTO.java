package com.example.springbootdemo.scheduled.bean;


import com.example.springbootdemo.validator.YjxBaseConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author wb_90
 * @title: MessageDTO
 * @projectName saasproject
 * @date 2019/12/18 15:32
 **/
@Data
public class MessageDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    @YjxBaseConstraint(identity = 1,checkColumn ={"max"})
    private String yjxBaseConstraint;

    /**
     * 检查日期是否在未来
     * 支持的数据类型：
     * java.util.Date, java.util.Calendar, java.time.Instant, java.time.LocalDate, java.time.LocalDateTime, java.time.LocalTime, java.time.MonthDay, java.time.OffsetDateTime, java.time.OffsetTime, java.time.Year, java.time.YearMonth, java.time.ZonedDateTime, java.time.chrono.HijrahDate, java.time.chrono.JapaneseDate, java.time.chrono.MinguoDate, java.time.chrono.ThaiBuddhistDate
     * 如果 Joda Time API 在类路径中，ReadablePartial 和ReadableInstant 的任何实现类
     */
    @Future
    private Date dateFuture;

    /**
     *检查日期是否在过去
     * 支持数据类型：同@Future
     */
    @Past
    private Date datePast;

    /**
     * 检查值是否小于或等于指定的最大值
     * 支持的数据类型：
     * BigDecimal, BigInteger, byte, short, int, long, 原生类型的封装类, CharSequence 的任意子类（字符序列表示的数字）, Number 的任意子类, javax.money.MonetaryAmount 的任意子类
     */
    @Max(value=3)
    private Integer max;


    /**
     * 检查值是否大于或等于指定的最大值
     * 支持的数据类型：
     * BigDecimal, BigInteger, byte, short, int, long, 原生类型的封装类, CharSequence 的任意子类（字符序列表示的数字）, Number 的任意子类, javax.money.MonetaryAmount 的任意子类
     */
    @Min(value = 3)
    private Integer min;

    /**
     * 检查值是否为最多包含 integer 位整数和 fraction 位小数的数字
     * 支持的数据类型：
     * BigDecimal, BigInteger, CharSequence, byte, short, int, long 、原生类型的封装类、任何 Number 子类。
     */
    @Digits(integer=3, fraction=3)
    private Integer integer;

    /**
     * value : 匹配值
     * inclusive : 是否包含
     */
    @DecimalMax(value="3", inclusive=true)
    private BigDecimal decimalMax;

    /**
     * value : 匹配值
     * inclusive : 是否包含
     */
    @DecimalMin(value="3", inclusive=false)
    private BigDecimal decimalMin;

    /**
     * 检查元素是否为 true，支持数据类型：boolean、Boolean
     */
    @AssertTrue
    private Boolean isTrue;

    /**
     * 检查元素是否为 false，支持数据类型：boolean、Boolean
     */
    @AssertFalse
    private Boolean isFalse;

    /**
     *
     * 检查值是否不为 null
     * 支持数据类型：任何类型
     *
     * 检查指定的字符序列是否为有效的电子邮件地址。可选参数 regexp 和 flags 允许指定电子邮件必须匹配的附加正则表达式（包括正则表达式标志）。
     * 支持的数据类型：CharSequence
     */
    @NotNull
    @Email
    private String email;

    /**
     * 检查元素是否为 null 或 空
     * 支持数据类型：CharSequence, Collection, Map, arrays
     *
     * 检查元素个数是否在 min（含）和 max（含）之间
     * 支持数据类型：CharSequence，Collection，Map, arrays
     */
    @NotEmpty
    @Size(min=3, max=6)
    private List<String> List;


    /**
     * 检查字符序列是否为空，以及去空格后的长度是否大于 0。与 @NotEmpty 的不同之处在于，此约束只能应用于字符序列，并且忽略尾随空格。
     * 支持数据类型：CharSequence
     */
    @NotBlank(message="用户名不能为空")
    private String username;

    @NotNull
    @Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}$",message="出生日期格式不正确")
    private String birthday;


}
