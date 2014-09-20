package com.nutomic.syncthingandroid.test.syncthing;

import android.content.Intent;
import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.MediumTest;

import com.nutomic.syncthingandroid.syncthing.BootReceiver;
import com.nutomic.syncthingandroid.syncthing.SyncthingService;
import com.nutomic.syncthingandroid.test.MockContext;

/**
 * Tests that {@link com.nutomic.syncthingandroid.syncthing.BootReceiver} starts the right service
 * ({@link com.nutomic.syncthingandroid.syncthing.SyncthingService}.
 */
public class BootReceiverTest extends AndroidTestCase {

    private BootReceiver mReceiver;
    private MockContext mContext;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mReceiver = new BootReceiver();
        mContext = new MockContext(null);
    }

    @MediumTest
    public void testOnReceiveCharging() {
        mReceiver.onReceive(mContext, null);
        assertEquals(1, mContext.getReceivedIntents().size());

        Intent receivedIntent = mContext.getReceivedIntents().get(0);
        assertEquals(SyncthingService.class.getName(), receivedIntent.getComponent().getClassName());
        mContext.clearReceivedIntents();
    }
}