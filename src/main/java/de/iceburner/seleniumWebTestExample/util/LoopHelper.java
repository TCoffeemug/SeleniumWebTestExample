package de.iceburner.seleniumWebTestExample.util;

import java.util.concurrent.TimeUnit;

/**
 * Class to help looping and waiting for certain events. User creates a
 * LoopHelper instance and implements the getCurrentState() method of the ICheck
 * interface.
 *
 * @author Thomas Eisbrenner
 *
 * @param <T>
 */
public class LoopHelper<T> {

	/**
	 * Interface to be implemented by user of the loop
	 *
	 * @param <T>
	 */
	public interface ICheck<T> {

		/**
		 * Method to be implemented, which will be called periodically by
		 * LoopHelper
		 *
		 * @return true, if check successful, false otherwise. Must return true
		 *         to stop the loop.
		 */
		public T getCurrentState();
	}

	/**
	 * Exception thrown in case of timeout
	 *
	 */
	public static class LoopTimeoutException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public LoopTimeoutException(String message) {
			super(message);
		}

	}

	private static final int DEFAULT_ITERATION_DELAY_IN_SECONDS = 1;

	private ICheck<?> mCheck;
	private int mTimeoutInSeconds;
	private T mExpectedState;
	private int mIterationDelayInSec;

	/**
	 * LoopHelper that loops and checks every "iterationDelays" in seconds until
	 * the "expectedState" or "timeout" is reached
	 *
	 * @param timeout
	 * @param iterationDelay
	 * @param expectedState
	 * @param check-
	 *            ICheck<?> - to be implemented when creating LoopHelper
	 */
	public LoopHelper(int timeout, int iterationDelay, T expectedState, ICheck<?> check) {
		mCheck = check;
		mTimeoutInSeconds = timeout;
		mExpectedState = expectedState;
		mIterationDelayInSec = iterationDelay;
	}

	/**
	 * LoopHelper that loops and checks every second until the "expectedState"
	 * or "timeout" is reached
	 *
	 * @param timeout
	 * @param expectedState
	 * @param check
	 *            - ICheck<?> - to be implemented when creating LoopHelper
	 */
	public LoopHelper(int timeout, T expectedState, ICheck<?> check) {
		mCheck = check;
		mTimeoutInSeconds = timeout;
		mExpectedState = expectedState;
		mIterationDelayInSec = DEFAULT_ITERATION_DELAY_IN_SECONDS;
	}

	/**
	 * starts the loop
	 */
	public void run() {
		final long timeStarted = System.currentTimeMillis();
		T currentState = null;
		while ((System.currentTimeMillis() - timeStarted) < (TimeUnit.SECONDS.toMillis(mTimeoutInSeconds))) {
			try {
				TimeUnit.SECONDS.sleep(mIterationDelayInSec);
			} catch (InterruptedException e) {
				System.err.println("LoopHelper delay sleep was interrupted");
			}
			currentState = (T) mCheck.getCurrentState();
			if (mExpectedState.equals(currentState)) {
				return;
			}
		}
		String errorMessage = "Was waiting for " + mExpectedState + " for "
				+ ((System.currentTimeMillis() - timeStarted) / 1000) + " seconds. Result was " + currentState;
		throw new LoopTimeoutException(errorMessage);
	}

}