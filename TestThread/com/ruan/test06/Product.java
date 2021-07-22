package TestThread.com.ruan.test06;

/**
 * @PackgeName: TestThread.com.ruan.test06
 * @ClassName: Product
 * @Author: 小天才
 * Date: 2021/7/2 18:11
 * project name: Data-structure-and-algorithm
 * @Version: 0.0.1
 * @Description: 商品类
 */
public class Product {
    private String brand;
    private String name;
    private Boolean flag = false;//是否有商品
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
