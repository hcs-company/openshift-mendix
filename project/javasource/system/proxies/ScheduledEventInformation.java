// This file was generated by Mendix Modeler.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package system.proxies;

public class ScheduledEventInformation
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject scheduledEventInformationMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "System.ScheduledEventInformation";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Name("Name"),
		Description("Description"),
		StartTime("StartTime"),
		EndTime("EndTime"),
		Status("Status");

		private java.lang.String metaName;

		MemberNames(java.lang.String s)
		{
			metaName = s;
		}

		@Override
		public java.lang.String toString()
		{
			return metaName;
		}
	}

	public ScheduledEventInformation(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "System.ScheduledEventInformation"));
	}

	protected ScheduledEventInformation(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject scheduledEventInformationMendixObject)
	{
		if (scheduledEventInformationMendixObject == null)
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		if (!com.mendix.core.Core.isSubClassOf("System.ScheduledEventInformation", scheduledEventInformationMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a System.ScheduledEventInformation");

		this.scheduledEventInformationMendixObject = scheduledEventInformationMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'ScheduledEventInformation.load(IContext, IMendixIdentifier)' instead.
	 */
	@Deprecated
	public static system.proxies.ScheduledEventInformation initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return system.proxies.ScheduledEventInformation.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.getSudoContext() can be used to obtain sudo access).
	 */
	public static system.proxies.ScheduledEventInformation initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new system.proxies.ScheduledEventInformation(context, mendixObject);
	}

	public static system.proxies.ScheduledEventInformation load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return system.proxies.ScheduledEventInformation.initialize(context, mendixObject);
	}

	public static java.util.List<system.proxies.ScheduledEventInformation> load(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String xpathConstraint) throws com.mendix.core.CoreException
	{
		java.util.List<system.proxies.ScheduledEventInformation> result = new java.util.ArrayList<system.proxies.ScheduledEventInformation>();
		for (com.mendix.systemwideinterfaces.core.IMendixObject obj : com.mendix.core.Core.retrieveXPathQuery(context, "//System.ScheduledEventInformation" + xpathConstraint))
			result.add(system.proxies.ScheduledEventInformation.initialize(context, obj));
		return result;
	}

	/**
	 * Commit the changes made on this proxy object.
	 */
	public final void commit() throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Commit the changes made on this proxy object using the specified context.
	 */
	public final void commit(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Delete the object.
	 */
	public final void delete()
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}

	/**
	 * Delete the object using the specified context.
	 */
	public final void delete(com.mendix.systemwideinterfaces.core.IContext context)
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}
	/**
	 * @return value of Name
	 */
	public final java.lang.String getName()
	{
		return getName(getContext());
	}

	/**
	 * @param context
	 * @return value of Name
	 */
	public final java.lang.String getName(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Name.toString());
	}

	/**
	 * Set value of Name
	 * @param name
	 */
	public final void setName(java.lang.String name)
	{
		setName(getContext(), name);
	}

	/**
	 * Set value of Name
	 * @param context
	 * @param name
	 */
	public final void setName(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String name)
	{
		getMendixObject().setValue(context, MemberNames.Name.toString(), name);
	}

	/**
	 * @return value of Description
	 */
	public final java.lang.String getDescription()
	{
		return getDescription(getContext());
	}

	/**
	 * @param context
	 * @return value of Description
	 */
	public final java.lang.String getDescription(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Description.toString());
	}

	/**
	 * Set value of Description
	 * @param description
	 */
	public final void setDescription(java.lang.String description)
	{
		setDescription(getContext(), description);
	}

	/**
	 * Set value of Description
	 * @param context
	 * @param description
	 */
	public final void setDescription(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String description)
	{
		getMendixObject().setValue(context, MemberNames.Description.toString(), description);
	}

	/**
	 * @return value of StartTime
	 */
	public final java.util.Date getStartTime()
	{
		return getStartTime(getContext());
	}

	/**
	 * @param context
	 * @return value of StartTime
	 */
	public final java.util.Date getStartTime(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.util.Date) getMendixObject().getValue(context, MemberNames.StartTime.toString());
	}

	/**
	 * Set value of StartTime
	 * @param starttime
	 */
	public final void setStartTime(java.util.Date starttime)
	{
		setStartTime(getContext(), starttime);
	}

	/**
	 * Set value of StartTime
	 * @param context
	 * @param starttime
	 */
	public final void setStartTime(com.mendix.systemwideinterfaces.core.IContext context, java.util.Date starttime)
	{
		getMendixObject().setValue(context, MemberNames.StartTime.toString(), starttime);
	}

	/**
	 * @return value of EndTime
	 */
	public final java.util.Date getEndTime()
	{
		return getEndTime(getContext());
	}

	/**
	 * @param context
	 * @return value of EndTime
	 */
	public final java.util.Date getEndTime(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.util.Date) getMendixObject().getValue(context, MemberNames.EndTime.toString());
	}

	/**
	 * Set value of EndTime
	 * @param endtime
	 */
	public final void setEndTime(java.util.Date endtime)
	{
		setEndTime(getContext(), endtime);
	}

	/**
	 * Set value of EndTime
	 * @param context
	 * @param endtime
	 */
	public final void setEndTime(com.mendix.systemwideinterfaces.core.IContext context, java.util.Date endtime)
	{
		getMendixObject().setValue(context, MemberNames.EndTime.toString(), endtime);
	}

	/**
	 * Set value of Status
	 * @param status
	 */
	public final system.proxies.EventStatus getStatus()
	{
		return getStatus(getContext());
	}

	/**
	 * @param context
	 * @return value of Status
	 */
	public final system.proxies.EventStatus getStatus(com.mendix.systemwideinterfaces.core.IContext context)
	{
		Object obj = getMendixObject().getValue(context, MemberNames.Status.toString());
		if (obj == null)
			return null;

		return system.proxies.EventStatus.valueOf((java.lang.String) obj);
	}

	/**
	 * Set value of Status
	 * @param status
	 */
	public final void setStatus(system.proxies.EventStatus status)
	{
		setStatus(getContext(), status);
	}

	/**
	 * Set value of Status
	 * @param context
	 * @param status
	 */
	public final void setStatus(com.mendix.systemwideinterfaces.core.IContext context, system.proxies.EventStatus status)
	{
		if (status != null)
			getMendixObject().setValue(context, MemberNames.Status.toString(), status.toString());
		else
			getMendixObject().setValue(context, MemberNames.Status.toString(), null);
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return scheduledEventInformationMendixObject;
	}

	/**
	 * @return the IContext instance of this proxy, or null if no IContext instance was specified at initialization.
	 */
	public final com.mendix.systemwideinterfaces.core.IContext getContext()
	{
		return context;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final system.proxies.ScheduledEventInformation that = (system.proxies.ScheduledEventInformation) obj;
			return getMendixObject().equals(that.getMendixObject());
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return getMendixObject().hashCode();
	}

	/**
	 * @return String name of this class
	 */
	public static java.lang.String getType()
	{
		return "System.ScheduledEventInformation";
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@Deprecated
	public java.lang.String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}
