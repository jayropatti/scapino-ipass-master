package nl.hu.bep.Persistence;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import nl.hu.bep.domeinmodel.Filiaal;
import nl.hu.bep.domeinmodel.Rayon;

import java.io.*;

import static nl.hu.bep.domeinmodel.Rayon.setRayon;

public class PersistenceManager {

    private static String ENDPOINT = "https://webbepdemo.blob.core.windows.net/";
    private static String SAS_TOKEN = "?sv=2020-08-04&ss=bfqt&srt=sco&sp=rwdlacupitfx&se=2022-08-02T18:11:58Z&st=2022-06-01T10:11:58Z&spr=https&sig=IhonacacnQFfuwltMzQ0XJtXfSvM8UEULc2%2BTPwwM%2F4%3D";
    private static String CONTAINER = "rayoncontainer";

    private static BlobContainerClient blobContainerClient = new BlobContainerClientBuilder()
            .endpoint(ENDPOINT)
            .sasToken(SAS_TOKEN)
            .containerName(CONTAINER)
            .buildClient();


    public static void loadWorldFromAzure() throws IOException, ClassNotFoundException{
        if (blobContainerClient.exists()){
            BlobClient blobClient = blobContainerClient.getBlobClient("world_blob");

            if (blobClient.exists()){

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                blobClient.download(baos);

                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);

                Object loadedObj = ois.readObject();
                if (loadedObj instanceof Rayon){
                    Rayon loadedRayon = (Rayon)loadedObj;
                    setRayon(loadedRayon);
                }
                baos.close();
                ois.close();
            }
        } else throw new IllegalStateException("Container not found...");
    }

    public static void saveWorldToAzure() throws IOException {
        if (!blobContainerClient.exists())
            blobContainerClient.create();

        BlobClient blobClient = blobContainerClient.getBlobClient("world_blob");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(Rayon.getRayon());

        byte[] bytez = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
        blobClient.upload(bais, bytez.length, true);

        oos.close();
        bais.close();

    }
}
