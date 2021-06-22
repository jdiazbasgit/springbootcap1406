package curso.cap.springboot.batch;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private CursoReader cursoReader;
	@Autowired
	private CursoProcesor cursoProcesor;
	@Autowired
	private CursoWriter cursoWriter;

	
	@Bean
	public RunIdIncrementer runIdIncrementer() {
		JobParameter parameter= new JobParameter(new Date());
		Map<String, JobParameter> mapaParametros= new HashMap<>();
		mapaParametros.put("trabajo", parameter);
		JobParameters parametros= new JobParameters(mapaParametros);
		RunIdIncrementer idIncrementer= new RunIdIncrementer();
		//idIncrementer.getNext(parametros);
		return idIncrementer;
	}
	
	@Bean
	public Job customerReportJob() {
		return getJobBuilderFactory().get("customerReportJob").start(taskletStep()).next(chunkStep()).build();
	}
	
	@Bean
	public Job jobParametersJob() {
		
		
		return jobBuilderFactory.get("jobParametersJob").incrementer(runIdIncrementer()).start(taskletStep()).build();
	}

	@Bean
	public Step taskletStep() {
		return getStepBuilderFactory().get("taskletStep").tasklet(tasklet()).build();
	}

	@Bean
	public Tasklet tasklet() {
		return (contribution, chunkContext) -> {
			
			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	public Step chunkStep() {
		return getStepBuilderFactory().get("chunkStep").<List<String>, List<Integer>>chunk(20).reader(getCursoReader())
				.processor(getCursoProcesor()).writer(getCursoWriter()).build();
	}

}
