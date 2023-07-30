package Entertainment.EMT.EMTShop;

import org.opencv.core.Core;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.awt.*;

@Component
public class BScanner implements CommandLineRunner {
   private final OrderService orderService;

    public BScanner(OrderService orderService) {
        this.orderService = orderService;
    }



    @Override
    public void run(String...args)throws Exception{
       		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		EventQueue.invokeLater(new Runnable() {
			// Overriding existing run() method
			@Override public void run()
			{
				final Camera camera = new Camera(orderService);

				// Start camera in thread
				new Thread(new Runnable() {
					@Override public void run()
					{
						camera.startCamera();
					}
				}).start();
			}
		});
   }

}
