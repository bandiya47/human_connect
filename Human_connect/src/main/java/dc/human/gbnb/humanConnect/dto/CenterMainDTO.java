package dc.human.gbnb.humanConnect.dto;

public class CenterMainDTO {
    private String userId;
    private String name;
    private String phone;
    private String status; // REG_RESULT 필드를 상태로 사용
    private String rejectReason; // REJECT_RS 필드를 거절 사유로 사용

    public CenterMainDTO() {
    }

    public CenterMainDTO(String userId, String name, String phone) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;        
    }

    // Getter와 Setter 메서드
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }
}