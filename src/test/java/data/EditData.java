package data;

public class EditData {
    private String alertMessage;

    private String errorMsgEmptyName;
    private String errorMsgEmptyPhone;
    private String errorMsgWrongFormatPhone;

    public EditData(String alertMessage){
        this.alertMessage = alertMessage;
    }

    public EditData(String errorMsgEmptyName, String errorMsgEmptyPhone, String errorMsgWrongFormatPhone){
        this.errorMsgEmptyName = errorMsgEmptyName;
        this.errorMsgEmptyPhone = errorMsgEmptyPhone;
        this.errorMsgWrongFormatPhone = errorMsgWrongFormatPhone;
    }

    public String getAlertMessage(){
        return alertMessage;
    }

    public String getErrorMsgEmptyName(){
        return errorMsgEmptyName;
    }

    public String getErrorMsgEmptyPhone(){
        return errorMsgEmptyPhone;
    }

    public String getErrorMsgWrongFormatPhone(){
        return errorMsgWrongFormatPhone;
    }


    public static enum TextAlertMeassage {
        TEXT_ALERT_MEASSAGE("В данный момент онлайн бронирование не активно.");

        private String text;
        private TextAlertMeassage(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return this.text;
        }
    }

    public static enum ErrorMessages {
        ERROR_MESSAGE_EMPTY_NAME("* Необходимо заполнить"),
        ERROR_MESSAGE_EMPTY_PHONE("* Необходимо заполнить"),
        ERROR_MESSAGE_WRONG_FORMAT_PHONE("* Неправильный формат телефона");

        private String text;
        private ErrorMessages(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return this.text;
        }
    }

    public static EditData generateTextAlertMessage(){
        return new EditData(TextAlertMeassage.TEXT_ALERT_MEASSAGE.toString());
    }

    public static EditData generateTextErrorMessages(){
        return new EditData(ErrorMessages.ERROR_MESSAGE_EMPTY_NAME.toString(),
                ErrorMessages.ERROR_MESSAGE_EMPTY_PHONE.toString(),
                ErrorMessages.ERROR_MESSAGE_WRONG_FORMAT_PHONE.toString());
    }
}
