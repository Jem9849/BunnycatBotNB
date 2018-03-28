package bot.model;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import bot.controller.BotController;
import bot.model.*;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;

public class Help implements ICommand 
{
	private BotController botControl;
	private Picture pic;
	private Reaction react;
	private RockPaperScissors rps;
	private updateUsername update;
	
	public Help()
	{
		pic = new Picture();
		botControl = new BotController();
		react = new Reaction();
		rps = new RockPaperScissors();
		update = new updateUsername();
	}

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
		if (args[0].toLowerCase().equals("help"))
		{
			botControl.messageSend("**" + pic.getName() + "**", event);
		}

	}

	@Override
	public String getDescription() 
	{
		return "returns a list of commands.";
	}

	@Override
	public String getName() 
	{
		
		return "help";
	}

}
