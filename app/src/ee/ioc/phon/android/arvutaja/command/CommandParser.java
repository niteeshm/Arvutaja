package ee.ioc.phon.android.arvutaja.command;

import ee.ioc.phon.android.arvutaja.R;
import android.content.Context;

public class CommandParser {

	public static Command getCommand(Context context, String command) throws CommandParseException {
		if (command == null) {
			throw new CommandParseException();
		}

		if (Alarm.isCommand(command))
			return new Alarm(command, context.getString(R.string.alarmExtraMessage));

		if (WebSearch.isCommand(command))
			return new WebSearch(command);

		if (Dial.isCommand(command))
			return new Dial(command);

		if (Expr.isCommand(command))
			return new Expr(command);

		if (Search.isCommand(command))
			return new Search(command);

		if (Unitconv.isCommand(command))
			return new Unitconv(command);

		if (Direction.isCommand(command))
			return new Direction(command);

		return new DefaultCommand(command);
	}

}