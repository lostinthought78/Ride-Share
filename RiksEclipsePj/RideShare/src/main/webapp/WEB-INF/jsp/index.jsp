<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <style>
       #map {
        height: 400px;
        width: 100%;
       }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
  </head>
  <body>
	  	<div id="displayArea" style="top: 0px; bottom: 0px; left: 0px; width: 300px; background-color: #6464de; position: fixed; color: white; font-weight: bold;">
	  		<a href="/profile" target="_blank" style="color: white;">View Your Profile</a><br/><br/>
	  		
	  		<c:url var="logoutUrl" value="/logout"/>
			<form action="${logoutUrl}" method="post">
			  <input type="submit" value="Sign Out" style = "border: none; background-color: white; padding: 3px 20px;" />
			  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
			<br />
					
	  		Driver Options: <br />
  			<form id="driverOptionForm">
		  		<div style="padding: 10px;">
		  			Smoking:<br />
		  			<div style="padding: 15px;">
		  				<input name="smoker" type="radio" value="true" /> No<br />
		  				<input name="smoker" type="radio" value="false" checked="checked" /> No Preference
		  			</div>
		  		</div>
	  			<div style="padding: 10px;">
	  				Luggage Space:
	  				<div style="padding: 15px;">
	  					<input name="luggage" type="radio" value="true" /> Yes<br />
	  					<input name="luggage" type="radio" value="false" checked="checked" /> No Preference
	  				</div>
	  			</div>
	  			<div style="padding: 10px;">
	  				Pet Friendly:
	  				<div style="padding: 15px;">
	  					<input name="pets" type="radio" value="true" /> Yes<br />
	  					<input name="pets" type="radio" value="false" checked="checked" /> No Preference
	  				</div>
	  			</div>
	  			<div style="padding: 10px;">
		  			Gender:
		  			<div style="padding: 15px;"> 
		  				<input name="gender" type="radio" value="M" /> Male<br />
		  				<input name="gender" type="radio" value="F" /> Female<br />
		  				<input name="gender" type="radio" value="" checked="checked" /> No Preference
		  			</div>
	  			</div>
	  </form>
	  			 <div id="manualGeocode" style="display: none;">
				    <input id="address" type="textbox" value="880 Old Magnolia Drive, Conway, SC 29526" style="width: 280px;"/><br />
				    <input type="button" value="Find Me" onclick="codeAddress()" />
				  </div>
	  	</div>
    <div id="map" style="left: 250px; width: 500px;"></div>
    <script>
    	$(function(){
    		$(document).on('click','.selectDriver',function(e){
    			//Cache the JQuery selector so that the div doesn't have to be selected multiple times
    			var $div = $(this).closest('.selectDriverOptionsDiv');
				var driverId = $div.attr('data-id');
    			$.ajax({
    	    		url: 'selectDriver'
    	    		,data:{
    	    			driverId: driverId
    	    		}
    				,success: function(message) {
						alert(message);
						$div.hide();
    				}
    			});
    			e.preventDefault();
    		});
    		$(document).on('click','.scheduleDriver',function(e){
    			$(this).next('.schedule').html('Please select a time: <select class="scheduledTime"><option value="5">5 Minutes</option><option value="10">10 Minutes</option><option value="15">15 Minutes</option><option value="20">20 Minutes</option><option value="25">25 Minutes</option><option value="30">30 Minutes</option></select> <input type="button" value="go" class="scheduleButton"/>');
    			e.preventDefault();
    		});
    		$(document).on('click','.scheduleButton',function(e){
    			//Cache the JQuery selector so that the div doesn't have to be selected multiple times
    			var $div = $(this).closest('.selectDriverOptionsDiv');
				var driverId = $div.attr('data-id');
    			$.ajax({
    	    		url: 'scheduleDriver'
    	    		,data:{
    	    			driverId: driverId
    	    			,scheduleDelay : $div.find('.scheduledTime option:selected').val() //Find the 
    	    		}
    				,success: function(message) {
						alert(message);
						$div.hide();
    				}
    			});
    			e.preventDefault();
    		});
    	});
    	driverMarkers=[]
	  function findDrivers(pos) {
			//Show User
			
			//Use ternary if to ensure position lat/long are functions
			var latitude = typeof pos.lat == 'function' ? pos.lat() : pos.lat;
			var longitude = typeof pos.lng == 'function' ? pos.lng() : pos.lng;
			
	    	$.ajax({
	    		url: 'findDrivers'
	    		,data : $('#driverOptionForm').serialize() + '&latitude=' + latitude + '&longitude='+ longitude +'&distance=5280'
	    		,success : function(drivers) {
	    			//Clear current drivers
	    			if(driverMarkers.length > 0) {
	    				for(x in driverMarkers) {
	    					driverMarkers[x].setMap(null);
	    					delete driverMarkers[x];
	    				}
	    				driverMarkers = [];
	    			}
	    			if(drivers.length == 0) {
		    			map.setCenter(pos);
		                map.setZoom(16);
		                alert("Sorry, no drivers were found within your serving distance.");
	    			} else {
		    			//Show Drivers
		    			var bounds = new google.maps.LatLngBounds();
		    			bounds.extend(pos);
		    			for(x in drivers) {
							var driverPos = {
	    		                lat: drivers[x].latitude,
	    		                lng: drivers[x].longitude
	    		            };
						
							var content = '';
							for(attr in drivers[x]) {
								if(attr != 'id') {
									content += '<div><b>'+attr+':</b>&nbsp;&nbsp;'+drivers[x][attr]+'</div>';
								}
							}
							
							content +='<div class="selectDriverOptionsDiv" data-id="'+drivers[x].id+'"><a href="#select" class="selectDriver">Select Driver</a>&nbsp;&nbsp;<a href="#schedule" class="scheduleDriver">Schedule</a><div class="schedule"></div></div>';
							
		    				var marker = new google.maps.Marker({
		    		            map: map,
		    		            position: driverPos,
		    		            icon : 'http://maps.google.com/mapfiles/kml/pal2/icon47.png',
		    		            content: content
		    		        });
		    				
					        marker.addListener('click', function() {
					          infowindow.setContent(this.content);
					          infowindow.open(map, this);
					        });
					        
		    				driverMarkers.push(marker);
		    				bounds.extend(driverPos);
		    			}
		    			//Adjust bounding box
	    				map.fitBounds(bounds);
	    			}
	    		}
	    	});
	  }
      function initMap() {
        var uluru = {lat: 33.8404837, lng: -79.0974256};
        map = new google.maps.Map(document.getElementById('map'), {
          zoom: 12,
          center: uluru
        });
        infowindow = new google.maps.InfoWindow();
        
		geocoder = new google.maps.Geocoder();
    	
		//HTML 5 GeoLocate
		if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
              lat: position.coords.latitude,
              lng: position.coords.longitude
            };
            var marker = new google.maps.Marker({
	            map: map,
	            position: pos
	        });
            findDrivers(pos);
          }, function() {
        	  $('#manualGeocode').show();
          });
        } else {
          // Browser doesn't support Geolocation
        	$('#manualGeocode').show();
        }
		
		codeAddress = function(){
    	    var address = document.getElementById('address').value;
    	    geocoder.geocode( { 'address': address}, function(results, status) {
    	      if (status == 'OK') {
    	        var marker = new google.maps.Marker({
    	            map: map,
    	            position: results[0].geometry.location
    	        });
    	        findDrivers(results[0].geometry.location);
    	      } else {
    	        alert('Geocode was not successful for the following reason: ' + status);
    	      }
    	    });
    	  }
      }
    </script>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyASLDkPyEt22-i0Qc4eysiD67qbsk6TIW4&callback=initMap"></script>
  </body>
</html>