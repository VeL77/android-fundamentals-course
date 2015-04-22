package org.hackafe.sunshine.data;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.test.AndroidTestCase;

import java.util.Date;

/**
 * Created by groupsky on 22.04.15.
 */
public class TestContentProvider extends AndroidTestCase {

    public void testWeHaveAProvider() {
        ContentProviderClient client = getContext().getContentResolver().acquireContentProviderClient(WeatherContract.ForecastTable.CONTENT_URI);
        assertNotNull("Can't find content provider", client);
        client.release();
    }

    public void testInsertData() {
        ContentValues values = new ContentValues();
        values.put(WeatherContract.ForecastTable.COLUMN_DATE, new Date().getTime());
        values.put(WeatherContract.ForecastTable.COLUMN_FORECAST, "some forecast for sunny days");
        Uri row = getContext().getContentResolver().insert(
                WeatherContract.ForecastTable.CONTENT_URI,
                values
        );
        assertNotNull(row);

        Cursor cursor = new WeatherDbHelper(getContext()).getReadableDatabase().query(
                //String table,
                WeatherContract.ForecastTable.TABLE_NAME,
                // String[] columns,
                null,
                // String selection,
                WeatherContract.ForecastTable.COLUMN_DATE + "=?",
                // String[] selectionArgs,
                new String[]{values.getAsString(WeatherContract.ForecastTable.COLUMN_DATE)},
                // String groupBy,
                null,
                // String having,
                null,
                // String orderBy
                null

        );

        assertEquals(1, cursor.getCount());
    }

}
