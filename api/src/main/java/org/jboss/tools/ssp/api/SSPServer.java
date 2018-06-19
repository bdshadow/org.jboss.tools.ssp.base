/*******************************************************************************
 * Copyright (c) 2018 Red Hat, Inc. Distributed under license by Red Hat, Inc.
 * All rights reserved. This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Red Hat, Inc.
 ******************************************************************************/
package org.jboss.tools.ssp.api;

import java.util.List;
import org.eclipse.lsp4j.jsonrpc.services.JsonSegment;

@JsonSegment("server")
public interface SSPServer<T extends SSPClient> {

	List<T> getClients();

	/**
	 * Connect the given chat client.
	 * Return a runnable which should be executed to disconnect the client.
	 */
	Runnable addClient(SocketLauncher<T> launcher);

	void removeClient(SocketLauncher<T> launcher);

	List<SocketLauncher<T>> getActiveLaunchers();
}
