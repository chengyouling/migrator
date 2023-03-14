package com.huaweicse.tools.migrator.hsf;

import java.io.File;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.huaweicse.tools.migrator.Utils;

@SpringBootTest
public class ModifySchedulerJobActionTest {

  private static final String BASE_PATH = System.getProperty("user.dir");

  private String TEMP_DIR_PATH;

  private String fileSeparator = File.separator;

  @Autowired
  private ModifySchedulerJobAction modifySchedulerJobAction;

  @BeforeEach
  public void setUp() throws Exception {
    TEMP_DIR_PATH = System.getProperty("java.io.tmpdir")
        + File.separator + Math.abs(new Random().nextInt());

    FileUtils.copyDirectoryToDirectory(new File(BASE_PATH + fileSeparator + "testfiles" + fileSeparator + "input"),
        new File(TEMP_DIR_PATH));
  }

  @AfterEach
  public void tearDown() throws Exception {

  }


  @Test
  public void testModifyHSFProviderAction() throws Exception {
    String localBaseFilePath = BASE_PATH + fileSeparator + "testfiles";
    String tempBaseFilePath = TEMP_DIR_PATH + fileSeparator + "input";
    modifySchedulerJobAction.run(tempBaseFilePath);

    String fileName = "ArchiveApiServerLogJob.java";
    Utils.assertFileContentEquals(
        localBaseFilePath + fileSeparator + "output" + fileSeparator + fileName,
        tempBaseFilePath + fileSeparator + fileName);

    fileName = "RetailAntaIL802Job.java";
    Utils.assertFileContentEquals(
        localBaseFilePath + fileSeparator + "output" + fileSeparator + fileName,
        tempBaseFilePath + fileSeparator + fileName);

    fileName = "DtcZyRetailSendJob.java";
    Utils.assertFileContentEquals(
        localBaseFilePath + fileSeparator + "output" + fileSeparator + fileName,
        tempBaseFilePath + fileSeparator + fileName);

    fileName = "CrmOuidJob.java";
    Utils.assertFileContentEquals(
        localBaseFilePath + fileSeparator + "output" + fileSeparator + fileName,
        tempBaseFilePath + fileSeparator + fileName);

    fileName = "MultipleWarehouseOrderOverdueWarningJob.java";
    Utils.assertFileContentEquals(
        localBaseFilePath + fileSeparator + "output" + fileSeparator + fileName,
        tempBaseFilePath + fileSeparator + fileName);
  }
}
