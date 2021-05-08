package cxc.transaction.entity;

import org.springframework.stereotype.Component;

/**
 * @author cxc
 * @date 2021/5/7
 */
@Component
public class User {
    private Integer id;
    private String realName;
    private String cardNo;
    private Integer balance;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", balance=" + balance +
                '}';
    }

    public User() {
    }

    public User(String realName, String cardNo, Integer balance) {
        this.realName = realName;
        this.cardNo = cardNo;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
