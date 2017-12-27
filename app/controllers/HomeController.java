package controllers;

import javax.inject.Inject;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import play.Logger;
import java.util.concurrent.CompletionStage;

public class HomeController extends Controller {

	private final JavaApplicationDatabase companyRepository;
	private final HttpExecutionContext httpExecutionContext;

	@Inject
	public HomeController(JavaApplicationDatabase companyRepository, HttpExecutionContext httpExecutionContext) {
		this.companyRepository = companyRepository;
		this.httpExecutionContext = httpExecutionContext;
	}

	public CompletionStage<Result> index() {
		return companyRepository.updateSomething().thenApplyAsync(list -> {
			Logger.info("A log message");
			return ok(views.html.index.render(list.getTotalCount()));
		}, httpExecutionContext.current());
	}
}