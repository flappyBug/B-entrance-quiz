package com.thoughtworks.capability.gtb.entrancequiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GtbEntranceQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtbEntranceQuizApplication.class, args);
	}

}

// TODO GTB-完成度: * 新增学员的接口没有校验姓名为空的情况
// TODO GTB-测试: * 包含了对Controller的测试，但是没有测到什么，没有遵循测试最佳实践
// TODO GTB-知识点: * Spring MVC相关的知识点掌握的不错
// TODO GTB-工程实践: * 项目划分合理，使用了分层架构
// TODO GTB-工程实践: * git commit message表意，遵循了小步提交