import estate.common.util.ExcelParse;
import estate.common.util.GsonUtil;
import estate.common.util.LogUtil;
import org.junit.Test;

/**
 * Created by kangbiao on 15-10-24.
 * 解析excel的测试类
 */
public class ExcelParseTest
{
    ExcelParse excelParse=new ExcelParse();

    @Test
    public void test() throws Exception
    {
        LogUtil.E(GsonUtil.getGson().toJson(excelParse.parseExcel("/home/kangbiao/桌面/test.xlsx")));
    }
}
