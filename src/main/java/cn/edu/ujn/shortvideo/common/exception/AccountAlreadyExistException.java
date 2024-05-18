package cn.edu.ujn.shortvideo.common.exception;

public class AccountAlreadyExistException extends BaseException{
    public AccountAlreadyExistException(){}

    public AccountAlreadyExistException(String message){
        super(message);
    }
}
