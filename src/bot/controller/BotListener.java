package bot.controller;

import com.Cardinal.CommandPackage.Proccessor.EventListener;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

// This listens to messages with a specific prefix.
public class BotListener extends EventListener 
{
	public BotListener(String prefix)
	{
		super(prefix);
	}
	
	// This gets the message sent by a user and checks if it starts with the correct prefix. If so we call processCommand
	// to take care of the message and understand what to do with it.
//	@EventSubscriber
//	public void messageEvent(MessageReceivedEvent event)
//	{
//		if (event.getMessage().getContent().toLowerCase().startsWith(prefix))
//		{
//			CommandControl.processCommand(event.getMessage(), prefix);
//		}
//	}
//
}
