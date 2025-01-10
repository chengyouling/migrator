package com.huaweicse.tools.migrator.anta;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.huaweicse.tools.migrator.hsf.ModifyHSFAction;
import com.huaweicse.tools.migrator.hsf.ModifyHSFConsumerAction;
import com.huaweicse.tools.migrator.hsf.ModifyHSFInterface2RestAction;
import com.huaweicse.tools.migrator.hsf.ModifyHSFMainClassAction;
import com.huaweicse.tools.migrator.hsf.ModifyHSFProviderAction;
import com.huaweicse.tools.migrator.hsf.ModifySchedulerJobAction;

@SpringBootTest
public class MigrateSupport {
  private String BASE_PATH;

  private String TEMP_DIR_PATH;

  // TODO: generics parameter detection

  @Autowired
  private ModifyHSFAction modifyHSFAction;

  @Autowired
  private ModifyHSFInterface2RestAction modifyHSFInterface2RestAction;

  @Autowired
  private ModifyHSFProviderAction modifyHSFProviderAction;

    @Autowired
    private ModifyHSFConsumerAction modifyHSFConsumerAction;

    @Autowired
    private ModifyHSFMainClassAction modifyHSFMainClassAction;

    @Autowired
    private ModifySchedulerJobAction modifySchedulerJobAction;

  @BeforeEach
  public void setUp() throws Exception {
//    TEMP_DIR_PATH = "D:\\repo\\temp";
//    FileUtils.copyDirectoryToDirectory(
//        new File(BASE_PATH),
//        new File(TEMP_DIR_PATH));
  }

  @AfterEach
  public void tearDown() throws Exception {
//    FileUtils.deleteDirectory(new File(TEMP_DIR_PATH));
  }

  @Test
  public void testModifyHSFInterface2Rest() throws Exception {
    modifyHSFInterface2RestAction.run("D:\\GitRepos\\QDport\\current\\V1.1\\manifest\\manifest\\manifest-api");
  }

  @Test
  public void testModifyHSFProvider() throws Exception {
    modifyHSFProviderAction.run("D:\\GitRepos\\QDport\\current\\V1.1\\manifest\\manifest\\manifest-service");
  }

  @Test
  public void testModifyHSFConsumer() throws Exception {
    modifyHSFConsumerAction.run("D:\\GitRepos\\QDport\\current\\V1.1\\manifest\\manifest\\manifest-web");
  }

  @Test
  public void testModifyHSFMainClassAction() throws Exception {
    modifyHSFMainClassAction.run("D:\\GitRepos\\QDport\\current\\V1.1\\manifest\\manifest");
  }

  @Test
  public void testModifySchedulerJobAction() throws Exception {
    modifySchedulerJobAction.run("D:\\GitRepos\\QDport\\current\\V1.1\\manifest\\manifest");
  }
}
