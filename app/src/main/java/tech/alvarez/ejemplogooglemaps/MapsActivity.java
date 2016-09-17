package tech.alvarez.ejemplogooglemaps;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
            return;
        }
        mMap.setMyLocationEnabled(true);

        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setCompassEnabled(true);
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.setZoomGesturesEnabled(false);


//        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);






// MARCADOR
        LatLng vinedos = new LatLng(-16.505415, -68.128506);

        MarkerOptions markerOptions = new MarkerOptions()
                .position(vinedos)
                .title("Viñedos")
                .snippet("Este es un lugar cerca de la U");

        mMap.addMarker(markerOptions);

//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vinedos, 15));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(vinedos, 15));

        // TRAZO

//        PolylineOptions polylineOptions = new PolylineOptions()
//                .color(ContextCompat.getColor(this, R.color.colorPrimary))
//                .width(8)
//                .add(new LatLng(-16.505415, -68.128506))
//                .add(new LatLng(-16.514673, -68.122525))
//                .add(new LatLng(-16.508998, -68.110106));
//
//
//        mMap.addPolyline(polylineOptions);
//
        // AREA

//        PolygonOptions polygonOptions = new PolygonOptions()
//                .fillColor(ContextCompat.getColor(this, R.color.colorPrimary2))
//                .add(new LatLng(-16.505415, -68.128506))
//                .add(new LatLng(-16.514673, -68.122525))
//                .add(new LatLng(-16.508998, -68.110106));
//
//        mMap.addPolygon(polygonOptions);
//

        // CIRCULO

        CircleOptions circleOptions = new CircleOptions()
                .center(new LatLng(-16.514673, -68.122525))
                .radius(500);

        mMap.addCircle(circleOptions);

    }
}
