package l.com.ldk.duykhanh.b6_sqlite.MODEL;

public class Student {

    private int mID;
    private String mName;
    private String mPhoneNumber;
    private String mAddress;
    private String mEmail;

    public Student() {
    }

    public Student(String mName, String mPhoneNumber, String mAddress, String mEmail) {
        this.mName = mName;
        this.mPhoneNumber = mPhoneNumber;
        this.mAddress = mAddress;
        this.mEmail = mEmail;
    }

    public Student(int mID, String mName, String mPhoneNumber, String mAddress, String mEmail) {
        this.mID = mID;
        this.mName = mName;
        this.mPhoneNumber = mPhoneNumber;
        this.mAddress = mAddress;
        this.mEmail = mEmail;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "mID=" + mID +
                ", mName='" + mName + '\'' +
                ", mPhoneNumber='" + mPhoneNumber + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mEmail='" + mEmail + '\'' +
                '}';
    }
}
