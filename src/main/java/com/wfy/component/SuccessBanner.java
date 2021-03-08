package com.wfy.component;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author wfy
 * @Description: 项目启动成功后输出动画
 * @Date 18:34 2021/03/08
 **/
@Component
public class SuccessBanner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception{
        System.out.println("     _______  __    __    ______   ______  _______     _______      _______ \n" +
                           "    /       ||  |  |  |  /      | /      ||   ____|   /       |    /       |\n" +
                           "   |   (----`|  |  |  | |  ,----'|  ,----'|  |__     |   (----`   |   (----`\n" +
                           "    \\   \\    |  |  |  | |  |     |  |     |   __|     \\   \\        \\   \\ \n" +
                           ".----)   |   |  `--'  | |  `----.|  `----.|  |____.----)   |   .----)   |   \n" +
                           "|_______/     \\______/   \\______| \\______||_______|_______/    |_______/    \n" +
                           "                                                                            \n"+
                           "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n" +
                           "|启|动|成|功|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|\n" +
                           "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");

    }
}
