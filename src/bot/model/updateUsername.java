package bot.model;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import bot.controller.BotController;
import bot.controller.FileReader;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MissingPermissionsException;

public class updateUsername implements ICommand 
{
	private String me;
	private String newName;
	private BotController botControl;
	
	public updateUsername()
	{
		me = FileReader.readConfig("DiscordId");
		botControl = new BotController();
		newName = "";
	}

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
		String compare = Long.toString(event.getAuthor().getLongID());
		
		if (compare.equals(me) && args.length >= 2)
		{
			newName = args[1];
			
			botControl.bot.changeUsername(newName);
		}
		
		else 
		{
			botControl.messageSend("You are either not Merciz, or you did not enter things correctly.", event);
		}
		
		

	}

	@Override
	public String getDescription() 
	{
		
		return "Updates bot username.";
	}

	@Override
	public String getName() 
	{
		
		return "username";
	}

}
