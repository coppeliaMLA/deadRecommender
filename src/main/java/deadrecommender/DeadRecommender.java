/*
 * Recommends authors etc using Wikipedias influenced by information
 */
package deadrecommender;

/**
 *
 * @author Simon Raper
 */

// import packages 

import java.io.*;
import java.util.*;

import com.google.common.io.Files;
import com.google.common.io.InputSupplier;
import com.google.common.io.Resources;

import java.net.URL;
import org.apache.mahout.cf.taste.common.Refreshable;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.IDRescorer;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class DeadRecommender implements Recommender {
    
    //Define variables
    
   
    private final DataModel model;
    private final GenericBooleanPrefUserBasedRecommender recInfluences;
    
    //Constructors
    
  public DeadRecommender() throws TasteException, IOException {
    this(new FileDataModel(readResourceToTempFile("ratings.dat")));
  }

  
    public DeadRecommender(DataModel model)
      throws TasteException, IOException {
    
 UserSimilarity similarity = new LogLikelihoodSimilarity(model);
    UserNeighborhood neighborhood =
      new NearestNUserNeighborhood(200, similarity, model);

     recInfluences = new GenericBooleanPrefUserBasedRecommender(
        model, neighborhood, similarity);
     this.model=model;
  }
  
  
  
    static File readResourceToTempFile(String resourceName) throws IOException {
    String absoluteResource = resourceName.startsWith("/") ? resourceName : '/' + resourceName;
    InputSupplier<? extends InputStream> inSupplier;
    try {
      URL resourceURL = Resources.getResource(DeadRecommender.class, absoluteResource);
      inSupplier = Resources.newInputStreamSupplier(resourceURL);
    } catch (IllegalArgumentException iae) {
      File resourceFile = new File(resourceName);
      inSupplier = Files.newInputStreamSupplier(resourceFile);
    }
    File tempFile = File.createTempFile("taste", null);
    tempFile.deleteOnExit();
    Files.copy(inSupplier, tempFile);
    return tempFile;
  }

    public List<RecommendedItem> recommend(long l, int i) throws TasteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<RecommendedItem> recommend(long l, int i, IDRescorer idr) throws TasteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public float estimatePreference(long l, long l1) throws TasteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setPreference(long l, long l1, float f) throws TasteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removePreference(long l, long l1) throws TasteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public DataModel getDataModel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void refresh(Collection<Refreshable> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}