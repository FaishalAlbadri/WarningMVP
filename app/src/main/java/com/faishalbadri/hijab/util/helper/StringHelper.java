package com.faishalbadri.hijab.util.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;


public class StringHelper {

  /**
   * The constant pattern2.
   */
  public static String pattern2 = "###,###";

  /**
   * Parsing int to string string.
   *
   * @param value the value
   * @param defaultValue the default value
   * @return the string
   */
  public static String parsingIntToString(Integer value, String defaultValue) {
    try {
      if (value != null || value.equals(null)) {
        return String.valueOf(value);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return defaultValue;
  }

  /**
   * Limit text string.
   *
   * @param text the text
   * @param limit the limit
   * @param tailCharacter the tail character
   * @return the string
   */
  public static String limitText(String text, Integer limit, String tailCharacter) {
    if (text.length() > limit) {
      return text.substring(0, limit) + tailCharacter;
    } else {
      return text;
    }
  }

  /**
   * Formating date from string string.
   *
   * @param fromFormat the from format
   * @param toFormat the to format
   * @param stringDate the string date
   * @return the string
   */
  public static String formatingDateFromString(String fromFormat, String toFormat,
      String stringDate) {
    //yyyy-MM-dd'T'HH:mm:ss.SSSZ
    SimpleDateFormat format = new SimpleDateFormat(fromFormat, Locale.getDefault());
    try {
      Date newDate = format.parse(stringDate);
      format = new SimpleDateFormat(toFormat, Locale.getDefault());
      return format.format(newDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return stringDate;
  }

  /**
   * Format time string.
   *
   * @param value the value
   * @return the string
   */
  public static String formatTime(String value) {
    return formatingDateFromString("yyyy-MM-dd HH:mm:ss", "HH:mm", value);
  }

  /**
   * Format date string.
   *
   * @param value the value
   * @return the string
   */
  public static String formatDate(String value) {
    return formatingDateFromString("yyyy-MM-dd HH:mm:ss", " EEEE, dd MMM yyyy", value);
  }

  /**
   * Format date with time string.
   *
   * @param value the value
   * @return the string
   */
  public static String formatDateWithTime(String value) {
    return formatingDateFromString("yyyy-MM-dd HH:mm:ss", "dd MMM yyyy 'at' HH:mm", value);
  }

  /**
   * Format date simple date string.
   *
   * @param withYear the with year
   * @param value the value
   * @return the string
   */
  public static String formatDateSimpleDate(Boolean withYear, String value) {
    if (withYear) {
      //become 01 Feb 2017
      return formatingDateFromString("yyyy-MM-dd", "dd MMM yyyy", value);
    } else {
      //become 01 Feb
      return formatingDateFromString("yyyy-MM-dd", "dd MMM", value);
    }
  }

  /**
   * Format date splitter string.
   *
   * @param value the value
   * @return the string
   */
  public static String formatDateSplitter(String value) {
    return formatingDateFromString("yyyy-MM-dd HH:mm:ss", "yyyyMMdd", value);
  }

  //public static String formatCurrency(String string) {
  //  DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
  //  DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
  //
  //  formatRp.setCurrencySymbol("Rp");
  //  formatRp.setMonetaryDecimalSeparator(',');
  //  formatRp.setGroupingSeparator('.');
  //
  //  kursIndonesia.setDecimalFormatSymbols(formatRp);
  //  kursIndonesia.setMaximumFractionDigits(0);
  //
  //  return kursIndonesia.format(Integer.parseInt(string));
  //}

  /**
   * Cut month string string.
   *
   * @param text the text
   * @return the string
   */
  public static String cutMonthString(String text) {

    return text.substring(0, 3);
  }

  /**
   * Generate summary string.
   *
   * @param Cart the cart
   * @return the string
   */
//  public static String generateSummary(List<CartTransactionData> Cart) {
//
//    String summary = "";
//    String subStringSummary = "";
//
//    for (int i = 0; i < Cart.size(); i++) {
//      CartTransactionData item = Cart.get(i);
//
//      if (item.getProductName() != null && !item.getProductName().equals("")) {
//        summary = summary + item.getProductName().trim();
//        if (i + 1 != Cart.size()) {
//          summary = summary + ", ";
//        }
//      } else {
//        if (i + 1 == Cart.size()) {
//          summary = summary.replaceAll(", $", "");
//        }
//      }
//    }
//
//    if (summary.length() > 200) {
//      subStringSummary = summary.substring(0, 199);
//    } else {
//      subStringSummary = summary;
//    }
//
//    return subStringSummary;
//  }

  /**
   * Gets error stringfrom list.
   *
   * @param listDataError the list data error
   * @return the error stringfrom list
   */
  public static String getErrorStringfromList(List<String> listDataError) {
    String errorCaption = "";
    if (listDataError.size() == 1) {
      errorCaption = listDataError.get(0);
    } else {
      for (int i = 0; i < listDataError.size(); i++) {
        errorCaption = errorCaption + listDataError.get(i);
        if ((i + 1) != listDataError.size()) {
          errorCaption = errorCaption + " ";
        }
      }
    }

    return errorCaption;
  }

  /**
   * convert currency text to int
   *
   * @param valueCurrency valueCurrency
   * @return integer value
   */
  public static Integer removeCurrencyOnText(String valueCurrency) {
    try {
      String value = valueCurrency.replaceAll("[%\\s\\D]", "");
      return (value.isEmpty() ? 0 : Integer.parseInt(value));
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  /**
   * Remove percent on text integer.
   *
   * @param valueCurrency the value currency
   * @return the integer
   */
  public static Integer removePercentOnText(String valueCurrency) {
    try {
      String value = valueCurrency.replaceAll("[%]", "");
      return (value.isEmpty() ? 0 : Integer.parseInt(value));
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  /**
   * Convert to subdomain string.
   *
   * @param fullText the full text
   * @return the string
   */
  public static String convertToSubdomain(String fullText) {

    String textLowerCase = fullText.toLowerCase();
    String removeChar = textLowerCase.replaceAll("[^a-zA-Z0-9\\-\\s]", "");
    String trim = removeChar.trim();
    String removeSpace = trim.replaceAll("\\s+", "-");

    return removeSpace;
  }

  /**
   * Number validation boolean.
   *
   * @param stringNumber the string number
   * @return the boolean
   */
  public static Boolean numberValidation(String stringNumber) {
    try {
      double d = Double.parseDouble(stringNumber);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }

  /**
   * Empty validation boolean.
   *
   * @param message the message
   * @return the boolean
   */
  public static boolean emptyValidation(final String message) {
    boolean isNotEmpty;

    isNotEmpty = !message.isEmpty();

    return isNotEmpty;
  }

  /**
   * Email validation boolean. example 085242199606, 6285242199606, not allow (+)
   *
   * @param email the email
   * @return the boolean
   */
  public static boolean emailValidation(String email) {

    if (emptyValidation(email)) {
      String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
      Pattern pattern = Pattern.compile(emailPattern);
      return pattern.matcher(email).matches();
    }
    return false;
  }
  /**
   * Making the separate email string.
   *
   * @param email the email string
   * @return the string masking
   */
//  public static String maskingEmailString(String email) {
//    String emailAccountChange;
//    String emailFullChange;
//
//    if (!email.equals("") && email != null) {
//      // split the email
//      String[] emailSpiting = email.split("@");
//
//      // initiate string buffer for manipulate string
//      StringBuilder emailAccount = new StringBuilder(emailSpiting[0]);
//
//      // email server ex:(gmail.com / yahoo.com)
//      String emailServer = emailSpiting[1];
//
//      int start = (int) Math.floor(emailAccount.length() / 2);
//      int end = emailAccount.length();
//
//      if (emailAccount.length() <= 1) {
//        emailAccountChange = emailAccount.replace(0, end, "*").toString();
//      } else if (emailAccount.length() > 10) {
//        // if length > 10 change from index 3
//        emailAccountChange = emailAccount.replace(3, end, Strings.repeat("*", (end - 3)))
//            .toString();
//      } else {
//        // if length > 0 change from middle to end
//        emailAccountChange = emailAccount.replace(start, end, Strings.repeat("*", start))
//            .toString();
//      }
//
//      emailFullChange = emailAccountChange + "@" + emailServer;
//    } else {
//      emailFullChange = "";
//    }
//
//    return emailFullChange;
//  }

  /**
   * Is not empty boolean.
   *
   * @param str the str
   * @return the boolean
   */
  public static boolean isNotEmpty(CharSequence str) {
    return !isEmpty(str);
  }

  /**
   * Is empty boolean.
   *
   * @param str the str
   * @return the boolean
   */
  public static boolean isEmpty(CharSequence str) {
    return str == null || str.length() == 0;
  }

  /**
   * Convert string to int integer.
   *
   * @param data the data
   * @return the integer
   */
  public static Integer convertStringToInt(String data) {
    Integer result;

    if (data.equals("") || data.equals("null")) {
      result = null;
    } else {
      result = Integer.valueOf(data);
    }

    return result;
  }

  /**
   * Convert string to capitalized string.
   *
   * @param data the data
   * @return the string
   */
  public static String convertStringToCapitalized(String data) {
    return data.substring(0, 1).toUpperCase() + data.substring(1).toLowerCase();
  }

  /**
   * get 2 char the initial of full text
   * for exp: "bakso senayan" => "BS"
   * "oreo coklat blueberry" => "OC"
   * "Kecap" => "K"
   *
   * @param text the full text
   * @return the string
   */
  public static String initialText(String text) {
    String initialText = "";

    if (text != null) {
      String[] imageText = text.trim().split(" ");

      if (imageText.length > 0 && !imageText[0].isEmpty()) {
        initialText = imageText[0].substring(0, 1).toUpperCase();
        if (imageText.length > 1) {
          // prevent error when the index 1 of imageText is null
          if (!imageText[1].isEmpty()) {
            initialText += imageText[1].substring(0, 1).toUpperCase();
          }
        } else {
          // prevent error when the index 0 of imageText just only has 1 character of text
          if (imageText[0].length() > 1) {
            initialText += imageText[0].substring(1, 2).toLowerCase();
          }

        }

      }
    }
    return initialText;
  }

  public static String youtubeLink(String code) {
    String link = "https://www.youtube.com/watch?v=";
    link = link + code;
    return link;
  }

  public static String youtubeLink(String code) {
    String link = "https://www.youtube.com/watch?v=";
    link = link + code;
    return link;
  }

  /**
   * The interface Email interface validation 2.
   */
  public interface EmailInterfaceValidation2 {

    /**
     * On valid.
     *
     * @param validEmail the valid email
     */
    void onValid(String validEmail);

    /**
     * On error.
     */
    void onError();
  }

  /**
   * The interface Email interface validation.
   */
  public interface EmailInterfaceValidation {

    /**
     * On valid.
     *
     * @param validEmailText the valid email text
     */
    void onValid(String validEmailText);

    /**
     * On error.
     *
     * @param errorMessage the error message
     */
    void onError(String errorMessage);
  }
}
