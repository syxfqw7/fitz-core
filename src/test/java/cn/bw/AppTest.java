package cn.bw;

import cn.bw.core.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
@Slf4j
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws Exception {
        log.info("hello slf4j..");
        log.error("this is a error msg");
        String time = DateUtil.getCurrentDateTimeStr();
        log.info("time: {}", time );
    }
}
