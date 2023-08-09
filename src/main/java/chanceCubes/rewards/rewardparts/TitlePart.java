package chanceCubes.rewards.rewardparts;

import chanceCubes.rewards.variableTypes.BoolVar;
import chanceCubes.rewards.variableTypes.IntVar;
import chanceCubes.rewards.variableTypes.StringVar;
import chanceCubes.util.GuiTextLocation;
import com.google.gson.JsonObject;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

public class TitlePart extends BasePart
{
	private StringVar type;
	private Component message;
	private IntVar fadeInTime = new IntVar(-1);
	private IntVar displayTime = new IntVar(-1);
	private IntVar fadeOutTime = new IntVar(-1);

	private BoolVar serverWide = new BoolVar(false);
	private IntVar range = new IntVar(32);

	public TitlePart(String type, String message)
	{
		this(type, message, 0);
	}

	public TitlePart(String type, TextComponent message)
	{
		this(new StringVar(type), message, new IntVar(0));
	}

	public TitlePart(StringVar type, JsonObject message)
	{
		this(type, Component.Serializer.fromJson(message), new IntVar(0));
	}

	public TitlePart(StringVar type, String message)
	{
		this(type, Component.Serializer.fromJson(message), new IntVar(0));
	}

	public TitlePart(String type, String message, int delay)
	{
		this(new StringVar(type), Component.Serializer.fromJson(message), new IntVar(delay));
	}

	public TitlePart(StringVar type, Component message, IntVar delay)
	{
		this.type = type;
		this.message = message;
		super.setDelay(delay);
	}

	public GuiTextLocation getType()
	{
		return GuiTextLocation.valueOf(type.getValue());
	}

	public TitlePart setType(String type)
	{
		return this.setType(new StringVar(type));
	}

	public TitlePart setType(StringVar type)
	{
		this.type = type;
		return this;
	}

	public Component getMessage()
	{
		return message;
	}

	public void setMessage(Component message)
	{
		this.message = message;
	}

	public int getFadeInTime()
	{
		return fadeInTime.getIntValue();
	}

	public TitlePart setFadeInTime(int fadeInTime)
	{
		return this.setFadeInTime(new IntVar(fadeInTime));
	}

	public TitlePart setFadeInTime(IntVar fadeInTime)
	{
		this.fadeInTime = fadeInTime;
		return this;
	}

	public int getDisplayTime()
	{
		return displayTime.getIntValue();
	}

	public TitlePart setDisplayTime(int displayTime)
	{
		return this.setDisplayTime(new IntVar(displayTime));
	}

	public TitlePart setDisplayTime(IntVar displayTime)
	{
		this.displayTime = displayTime;
		return this;
	}

	public int getFadeOutTime()
	{
		return fadeOutTime.getIntValue();
	}

	public TitlePart setFadeOutTime(int fadeOutTime)
	{
		return this.setFadeOutTime(new IntVar(fadeOutTime));
	}

	public TitlePart setFadeOutTime(IntVar fadeOutTime)
	{
		this.fadeOutTime = fadeOutTime;
		return this;
	}

	public boolean isServerWide()
	{
		return serverWide.getBoolValue();
	}

	public TitlePart setServerWide(boolean serverWide)
	{
		return this.setServerWide(new BoolVar(serverWide));
	}

	public TitlePart setServerWide(BoolVar serverWide)
	{
		this.serverWide = serverWide;
		return this;
	}

	public int getRange()
	{
		return range.getIntValue();
	}

	public TitlePart setRange(int range)
	{
		return this.setRange(new IntVar(range));
	}

	public TitlePart setRange(IntVar range)
	{
		this.range = range;
		return this;
	}

}