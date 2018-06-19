package org.jboss.tools.ssp.launching;

import org.jboss.tools.ssp.api.dao.CommandLineDetails;
import org.jboss.tools.ssp.eclipse.core.runtime.CoreException;
import org.jboss.tools.ssp.eclipse.core.runtime.IProgressMonitor;
import org.jboss.tools.ssp.eclipse.debug.core.ILaunch;
import org.jboss.tools.ssp.eclipse.jdt.launching.VMRunnerConfiguration;

public interface ICommandProvider {
	/**
	 * Returns the command line, envp, and working directory details 
	 * needed to launch a Java VM as specified in the given configuration,
	 * contributing results (debug targets and processes), to the
	 * given launch.
	 *
	 * @param configuration the configuration settings for this run
	 * @param launch the launch to contribute to
	 * @param monitor progress monitor or <code>null</code> A cancelable progress monitor is provided by the Job
	 *  framework. It should be noted that the setCanceled(boolean) method should never be called on the provided
	 *  monitor or the monitor passed to any delegates from this method; due to a limitation in the progress monitor
	 *  framework using the setCanceled method can cause entire workspace batch jobs to be canceled, as the canceled flag
	 *  is propagated up the top-level parent monitor. The provided monitor is not guaranteed to have been started.
	 * @exception CoreException if an exception occurs while launching
	 */
	public CommandLineDetails getCommandLineDetails(VMRunnerConfiguration configuration, ILaunch launch, IProgressMonitor monitor) throws CoreException;

}
