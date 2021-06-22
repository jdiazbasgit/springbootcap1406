package curso.cap.springboot.batch;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
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
	public Job customerReportJob() {
		return getJobBuilderFactory().get("customerReportJob").start(taskletStep()).next(chunkStep()).build();
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
