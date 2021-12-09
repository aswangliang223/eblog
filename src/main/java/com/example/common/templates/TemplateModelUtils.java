package com.example.common.templates;

import freemarker.template.*;
import lombok.experimental.UtilityClass;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.apache.commons.lang3.StringUtils.*;

/**
 * Freemarker 模型工具类
 *
 *
 * @author langhsu
 * @date 2017/11/14
 */
@UtilityClass
public class TemplateModelUtils {

    public  final DateFormat FULL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public  final int FULL_DATE_LENGTH = 19;

    public  final DateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public  final int SHORT_DATE_LENGTH = 10;

    public  String convertString(TemplateModel model) throws TemplateModelException {
        if (null != model) {
            if (model instanceof TemplateScalarModel) {
                return ((TemplateScalarModel) model).getAsString();
            } else if ((model instanceof TemplateNumberModel)) {
                return ((TemplateNumberModel) model).getAsNumber().toString();
            }
        }
        return null;
    }

    public  TemplateHashModel convertMap(TemplateModel model) throws TemplateModelException {
        if (null != model) {
            if (model instanceof TemplateHashModelEx) {
                return (TemplateHashModelEx) model;
            } else if (model instanceof TemplateHashModel) {
                return (TemplateHashModel) model;
            }
        }
        return null;
    }

    public  Integer convertInteger(TemplateModel model) throws TemplateModelException {
        if (null != model) {
            if (model instanceof TemplateNumberModel) {
                return ((TemplateNumberModel) model).getAsNumber().intValue();
            } else if (model instanceof TemplateScalarModel) {
                String s = ((TemplateScalarModel) model).getAsString();
                if (isNotBlank(s)) {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
        return null;
    }

    public  Short convertShort(TemplateModel model) throws TemplateModelException {
        if (null != model) {
            if (model instanceof TemplateNumberModel) {
                return ((TemplateNumberModel) model).getAsNumber().shortValue();
            } else if (model instanceof TemplateScalarModel) {
                String s = ((TemplateScalarModel) model).getAsString();
                if (isNotBlank(s)) {
                    try {
                        return Short.parseShort(s);
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
        return null;
    }

    public  Long convertLong(TemplateModel model) throws TemplateModelException {
        if (null != model) {
            if (model instanceof TemplateNumberModel) {
                return ((TemplateNumberModel) model).getAsNumber().longValue();
            } else if (model instanceof TemplateScalarModel) {
                String s = ((TemplateScalarModel) model).getAsString();
                if (isNotBlank(s)) {
                    try {
                        return Long.parseLong(s);
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
        return null;
    }

    public  Double convertDouble(TemplateModel model) throws TemplateModelException {
        if (null != model) {
            if (model instanceof TemplateNumberModel) {
                return ((TemplateNumberModel) model).getAsNumber().doubleValue();
            } else if (model instanceof TemplateScalarModel) {
                String s = ((TemplateScalarModel) model).getAsString();
                if (isNotBlank(s)) {
                    try {
                        return Double.parseDouble(s);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        }
        return null;
    }

    public  String[] convertStringArray(TemplateModel model) throws TemplateModelException {
        if (model instanceof TemplateSequenceModel) {
            TemplateSequenceModel smolder = (TemplateSequenceModel) model;
            String[] values = new String[smolder.size()];
            for (int i = 0; i < smolder.size(); i++) {
                values[i] = convertString(smolder.get(i));
            }
            return values;
        } else {
            String str = convertString(model);
            if (isNotBlank(str)) {
                return split(str,',');
            }
        }
        return null;
    }

    public  Boolean convertBoolean(TemplateModel model) throws TemplateModelException {
        if (null != model) {
            if (model instanceof TemplateBooleanModel) {
                return ((TemplateBooleanModel) model).getAsBoolean();
            } else if (model instanceof TemplateNumberModel) {
                return !(0 == ((TemplateNumberModel) model).getAsNumber().intValue());
            } else if (model instanceof TemplateScalarModel) {
                String temp = ((TemplateScalarModel) model).getAsString();
                if (isNotBlank(temp)) {
                    return Boolean.valueOf(temp);
                }
            }
        }
        return null;
    }

    public  Date convertDate(TemplateModel model) throws TemplateModelException {
        if (null != model) {
            if (model instanceof TemplateDateModel) {
                return ((TemplateDateModel) model).getAsDate();
            } else if (model instanceof TemplateScalarModel) {
                String temp = trimToEmpty(((TemplateScalarModel) model).getAsString());
                return parseDate(temp);
            }
        }
        return null;
    }

    public  Date parseDate(String date) {
        Date ret = null;
        try {
            if (FULL_DATE_LENGTH == date.length()) {
                ret = FULL_DATE_FORMAT.parse(date);
            } else if (SHORT_DATE_LENGTH == date.length()) {
                ret = SHORT_DATE_FORMAT.parse(date);
            }
        } catch (ParseException e) {
        }
        return ret;
    }
}
