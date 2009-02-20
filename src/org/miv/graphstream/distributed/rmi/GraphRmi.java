/*
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package org.miv.graphstream.distributed.rmi ;

import java.rmi.Remote;
import java.util.Map;


public interface GraphRmi extends Remote {


	/**
	 * Fonctions du server GraphStream
	 */

	public void init() throws java.rmi.RemoteException ;

	public void register(String uri) throws java.rmi.RemoteException ;

	public void unregister(String uri) throws java.rmi.RemoteException ;

	/**
	 * Fonctions courantes de GraphStream
	 */

	// Graph
	public void createGraph(String id, String graphClass) throws java.rmi.RemoteException ;

	//public void modifyGraph( String graphId, Map<String,Object> attributes ) throws java.rmi.RemoteException ;


	// Node
	public void addNode(String id) throws java.rmi.RemoteException;

	public void addNode(String tag, Map<String,Object> attributes ) throws java.rmi.RemoteException ;

	public void modifyNode ( String id, Map<String,Object> attributes ) throws java.rmi.RemoteException ;


	// Edge
	public void addEdge( String id, String node1, String node2 ) throws java.rmi.RemoteException ;

	public void addEdge( String id, String from, String to, boolean directed ) throws java.rmi.RemoteException ;

	public void addEdge ( String id, String from, String to, boolean directed, Map<String,Object> attributes ) throws java.rmi.RemoteException ;

	public void modifyEdge ( String id, Map<String,Object> attributes ) throws java.rmi.RemoteException ;

	// getNodeCount
	public int getNodeCount() throws java.rmi.RemoteException;

	// getEdgeCount
	public int[] getEdgeCount() throws java.rmi.RemoteException;

	//public int getVirtualEdgeCount() throws java.rmi.RemoteException;

	// removeEdge
	public void removeEdge( String id ) throws java.rmi.RemoteException;

	public void removeEdge( String from, String to ) throws java.rmi.RemoteException;


	// removeNode
	public void removeNode( String id ) throws java.rmi.RemoteException ;

	public void removeNodeOnVGraph( String id) throws java.rmi.RemoteException ;

	/**
	 * Fonctions complementaires
	 */

	public void nextDgsEvent() throws java.rmi.RemoteException;

	public void nextDgsStep() throws java.rmi.RemoteException;

	public boolean nextDgsVirtualStep(Integer pas) throws java.rmi.RemoteException;

	public boolean nextDgsVirtualEvents(Integer pas) throws java.rmi.RemoteException;

	public void setGraphReader(String fileName) throws java.rmi.RemoteException;

	public void loadData(String fileName) throws java.rmi.RemoteException;

	public GraphRmi getServerInst(String id) throws java.rmi.RemoteException;

	/**
	 * Generic request
	 */

	// Create new instance of algorithms
	public void newAlgorithm(String className, String instanceName) throws java.rmi.RemoteException ;

	// Requetes JSON (idees � pr�ciser et completer)
	public Object executeReq(Object req) throws java.rmi.RemoteException;

	// test
	public void test() throws java.rmi.RemoteException;

	/**
	 * Callback
	 */

	public void execute(Object req) throws java.rmi.RemoteException ;

	public Object callBack() throws java.rmi.RemoteException ;


}