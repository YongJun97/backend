package a1126.Doseo;

public class EBook extends Book{
    private double fileSize; // 파일의 크기(mb단위)
    private String format;   // 파일포멧(예: pdf , epub)

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public EBook(String title, String author, String iSBN, double fileSize, String format) {
        super(title, author, iSBN); // 부모 클래스 생성자 호출
        this.fileSize = fileSize;  
        this.format = format;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("file Size: " + fileSize + "MB");
    }
}
