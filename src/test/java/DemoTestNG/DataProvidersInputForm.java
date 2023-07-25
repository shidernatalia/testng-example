package DemoTestNG;

import org.testng.annotations.DataProvider;

public class DataProvidersInputForm {
    @DataProvider(name = "input-form-data-provider")
    public Object[][] inputFormData() {
        Object[][] data = new Object[2][3];

        data[0][0] = "Joe";  data[0][1] = "joe@gmail.com";  data[0][2] = "Password1!";
        data[1][0] = "Jane"; data[1][1] = "jane@gmail.com"; data[1][2] = "Password2!";

        return data;
    }
}
