package by.fomkin.web.controller;

import java.util.HashMap;
import java.util.Map;

import by.fomkin.web.controller.impl.DoAddNews;
import by.fomkin.web.controller.impl.DoChangeLocale;
import by.fomkin.web.controller.impl.DoDeleteNews;
import by.fomkin.web.controller.impl.DoRegistration;
import by.fomkin.web.controller.impl.DoSIgnIn;
import by.fomkin.web.controller.impl.DoSignOut;
import by.fomkin.web.controller.impl.GoToAddNewsPage;
import by.fomkin.web.controller.impl.GoToBasePage;
import by.fomkin.web.controller.impl.GoToEditNewsPage;
import by.fomkin.web.controller.impl.GoToErrorPage;
import by.fomkin.web.controller.impl.GoToNewsList;
import by.fomkin.web.controller.impl.GoToRegistrationPageCommand;
import by.fomkin.web.controller.impl.GoToViewNews;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandName.GO_TO_BASE_PAGE, new GoToBasePage());
		commands.put(CommandName.GO_TO_REGISTRATION_PAGE, new GoToRegistrationPageCommand());
		commands.put(CommandName.DO_SIGN_IN, new DoSIgnIn());
		commands.put(CommandName.DO_SIGN_OUT, new DoSignOut());
		commands.put(CommandName.GO_TO_NEWS_LIST, new GoToNewsList());
		commands.put(CommandName.GO_TO_VIEW_NEWS, new GoToViewNews());
		commands.put(CommandName.DO_REGISTRATION, new DoRegistration());
		commands.put(CommandName.GO_TO_ADD_NEWS_PAGE, new GoToAddNewsPage());
		commands.put(CommandName.DO_ADD_NEWS, new DoAddNews());
		commands.put(CommandName.DO_DELETE_NEWS, new DoDeleteNews());
		commands.put(CommandName.GO_TO_EDIT_NEWS_PAGE, new GoToEditNewsPage());
		commands.put(CommandName.GO_TO_ERROR_PAGE, new GoToErrorPage());
		commands.put(CommandName.DO_CHANGE_LOCALE, new DoChangeLocale());

	}

	public Command getCommand(String name) {
		CommandName commandName = CommandName.valueOf(name.toUpperCase());
		Command command = commands.get(commandName);
		return command;
	}

}
