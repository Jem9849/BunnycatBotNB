package bot.model;

import java.util.Iterator;

import com.Cardinal.CommandPackage.Commands.ICommand;
import com.Cardinal.CommandPackage.Exceptions.MissingArgumentsException;

import bot.controller.FileReader;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.impl.obj.ReactionEmoji;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.MessageHistory;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RequestBuffer;

public class Reaction implements ICommand 
{
	private MessageHistory messageH;
	private Iterator<IMessage> IM;
	private ReactionEmoji heartEmoji;
	
	public Reaction()
	{
		heartEmoji = ReactionEmoji.of("❤");
	}

	@Override
	public void execute(MessageReceivedEvent event, String[] args)
			throws MissingPermissionsException, MissingArgumentsException 
	{
		
		String me = FileReader.readConfig("DiscordId");
		
		if (Long.toString(event.getAuthor().getLongID()).equals(me))
		{
			messageH = event.getChannel().getMessageHistory(3);
			IM = messageH.iterator();
			
			while (IM.hasNext())
			{
				for (IMessage current : messageH)
				{
					String authorCheck = Long.toString(current.getAuthor().getLongID());
					
					
					if (authorCheck.equals(me))
					{
						RequestBuffer.request(() -> current.addReaction(heartEmoji));
					}
				}
			}
		}
		
		
		

	}

	@Override
	public String getDescription() 
	{
		
		return "Gives \"me\" a bunch of hearts.";
	}

	@Override
	public String getName() 
	{
		
		return "heart";
	}

}
